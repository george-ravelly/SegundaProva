package nok.terceiro.segundaprova.fragments.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import nok.terceiro.segundaprova.model.Anime
import nok.terceiro.segundaprova.banco.AppDatabase


@Suppress("DEPRECATION")
class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var list : LiveData<List<Anime>>

    init {
        val db : AppDatabase by lazy {
            Room.databaseBuilder(
                    application.applicationContext,
                    AppDatabase::class.java,
                    "Animes"
            ).build()
        }
        list = GetAllAsync(db).execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetAllAsync(var db:AppDatabase) : AsyncTask<Unit, Unit, LiveData<List<Anime>>>() {
        override fun doInBackground(vararg params: Unit?): LiveData<List<Anime>> {
            return db.animeDao().getAll()
        }
    }
}