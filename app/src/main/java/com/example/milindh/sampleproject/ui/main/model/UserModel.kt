package com.example.milindh.sampleproject.ui.main.model

sealed class Response
data class UserModel(val userId: String, val userName: String) : Response()
data class Error(val msg: String) : Response()