package com.example.milindh.sampleproject.ui.main.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.milindh.sampleproject.ui.main.repo.UserRepository
import com.example.milindh.sampleproject.ui.main.model.Response
import javax.inject.Inject

class UserViewModel @Inject constructor(private val mUserRepo: UserRepository) : ViewModel() {

    private var userModel = MutableLiveData<Response>()
    private val error = MutableLiveData<String>()

    fun getProgress() = mUserRepo.getProgress()

    fun getUserModel(): MutableLiveData<Response> = userModel

    fun getErrors() = error

    fun getData() {
        userModel.value?.let {
            return
        }
        userModel = mUserRepo.getUserData()
    }
}
