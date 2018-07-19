package com.example.milindh.sampleproject

import android.app.Application
import com.example.milindh.sampleproject.di.DaggerNetworkComponent
import com.example.milindh.sampleproject.di.NetworkComponent
import com.example.milindh.sampleproject.di.NetworkModule

class AppApplication : Application() {

    lateinit var networkComponent: NetworkComponent

    override fun onCreate() {
        super.onCreate()
        networkComponent = DaggerNetworkComponent
                .builder()
                .networkModule(NetworkModule)
                .build()
    }

}