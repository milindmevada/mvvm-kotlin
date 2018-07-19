package com.example.milindh.sampleproject.ui.main.repo

import android.arch.lifecycle.MutableLiveData
import com.example.milindh.sampleproject.shareddata.GithubServices
import com.example.milindh.sampleproject.ui.main.model.Error
import com.example.milindh.sampleproject.ui.main.model.Response
import com.example.milindh.sampleproject.ui.main.model.UserModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class UserRepository @Inject constructor(private val api: GithubServices) {

    private val progress = MutableLiveData<Boolean>()

    fun getProgress() = progress

    fun getUserData(): MutableLiveData<Response> {
        val data = MutableLiveData<Response>()
        api.getUsers("milind-mevada-stl")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { progress.postValue(true) }
                .subscribeBy(
                        onNext = {
                            progress.postValue(false)
                            data.value = UserModel("1", it["name"].asString)
                        },
                        onError = {
                            progress.postValue(false)
                            data.value = Error("User not found")
                        }
                )
        return data
    }

}