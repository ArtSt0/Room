package ru.artsto.room.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import ru.artsto.room.App

@Module
abstract class AppModule {
    @Binds
    abstract fun provideContext(application: App): Context
}
