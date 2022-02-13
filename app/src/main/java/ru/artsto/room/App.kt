package ru.artsto.room

import android.app.Application
import ru.artsto.room.di.AppComponent
import ru.artsto.room.di.DaggerAppComponent

class App:Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        //appDatabase = AppDatabase.getDatabase(this)
        appComponent = DaggerAppComponent.builder().application(this).build()
    }
}