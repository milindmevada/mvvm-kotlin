package com.example.milindh.sampleproject.shareddata

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubServices {
    @GET("users/{username}")
    fun getUsers(@Path("username") username: String): Observable<JsonObject>
}
