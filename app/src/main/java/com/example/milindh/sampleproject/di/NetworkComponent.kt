package com.example.milindh.sampleproject.di

import com.example.milindh.sampleproject.ui.main.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, ViewModelModule::class))
interface NetworkComponent {
    fun inject(activity: MainActivity)
}