package ru.artsto.room.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.artsto.room.room.Case
import ru.artsto.room.room.CaseDao
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val caseDao:CaseDao
):ViewModel() {
    private var disposables: CompositeDisposable = CompositeDisposable()

    init {
        insetCase(Case(name = "добавить новую запись"))
    }

    private fun insetCase(case:Case){
        caseDao.insertCase(case = case)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onComplete = {
                    Log.i("room", "запись добавлена")
                },
                onError = {
                    Log.i("room", "ошибка добавления = ${it.message}")
                }
            )
            .addTo(disposables)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}