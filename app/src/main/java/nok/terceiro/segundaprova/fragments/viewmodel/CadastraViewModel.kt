package nok.terceiro.segundaprova.fragments.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import nok.terceiro.segundaprova.banco.AppDatabase
import nok.terceiro.segundaprova.model.Anime

class CadastraViewModel(application: Application) : AndroidViewModel(application) {
    var name = ""
    var author = ""
    var year = ""
    var episodes = ""
    var genry = ""
    var rating = 0.0F
    var description = ""
    var onGoing = false

    private val db : AppDatabase by lazy {
        Room.databaseBuilder(
                application.applicationContext,
                AppDatabase::class.java,
                "Animes"
        ).allowMainThreadQueries().build()
    }

    fun save(){
        Log.i("CAD", "entrou")
        val anime = Anime(null, name, author, year.toInt(), episodes.toInt(), genry, rating.toDouble(), description, onGoing)
        db.animeDao().insert(anime)
        //HomeFragment().listAdapter.notifyDataSetChanged()
    }

}