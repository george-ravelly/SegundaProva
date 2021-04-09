@file:Suppress("DEPRECATION")

package nok.terceiro.segundaprova.fragments

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import nok.terceiro.segundaprova.banco.AppDatabase
import nok.terceiro.segundaprova.model.Anime

class AlteraViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var anime:Anime
    var id = 0
    var name = ""
    var author = ""
    var year = ""
    var episodes = ""
    var genry = ""
    var rating = 0.0F
    var description = ""
    var onGoing = false

    val db : AppDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "Animes"
        ).build()
    }

    fun setAnimeValue(animeId:Int) {
        id = animeId
        anime = GetAsync(db,id).execute().get()
        name = anime.name.toString()
        author = anime.author.toString()
        year = anime.year.toString()
        episodes = anime.episodes.toString()
        genry = anime.genry.toString()
        rating = anime.rating.toFloat()
        description = anime.description.toString()
        onGoing = anime.onGoing
    }

    fun atualizar(){
        var anime = Anime(id, name, author, year.toInt(), episodes.toInt(), genry, rating.toDouble(), description, onGoing)
        UpAsync(db, anime).execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetAsync(var db:AppDatabase, var id:Int) : AsyncTask<Unit, Unit, Anime>() {
        override fun doInBackground(vararg params: Unit?): Anime {
            return db.animeDao().findById(id)
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class UpAsync(var db:AppDatabase, var anime:Anime) : AsyncTask<Unit, Unit, Int>() {
        override fun doInBackground(vararg params: Unit?): Int {
            return db.animeDao().atualizar(anime)
        }
    }
}