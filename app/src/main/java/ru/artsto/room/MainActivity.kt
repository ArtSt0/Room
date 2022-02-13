package ru.artsto.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.artsto.room.compose.MainScreen
import ru.artsto.room.ui.theme.RoomTheme
import ru.artsto.room.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val vmMainView: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        ViewModelProvider(this, factory)[MainViewModel::class.java]

        setContent {
            RoomTheme {
                MainScreen()
            }
        }
    }
}
