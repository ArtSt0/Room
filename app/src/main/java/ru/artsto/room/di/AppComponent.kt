package ru.artsto.room.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.artsto.room.MainActivity
import ru.artsto.room.di.modules.AppModule
import ru.artsto.room.di.modules.RoomModule
import ru.artsto.room.di.modules.ViewModelFactoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ViewModelFactoryModule::class,
    RoomModule::class
])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}