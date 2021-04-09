package nok.terceiro.segundaprova.fragments.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import nok.terceiro.segundaprova.banco.AppDatabase
import nok.terceiro.segundaprova.model.Anime


@Suppress("DEPRECATION")
class AnimeViewModel(application: Application) : AndroidViewModel(application){
    var name = ""
    var author = ""
    var year = "Year: "
    var episodes = "Episodes: "
    var genry = "Genry: "
    var rating = "Rating:"
    var description = ""
    var onGoing = "onGoing: "

    val db:AppDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "Animes"
        ).build()
    }

    fun setAnime(id:Int){
        var anime = GetAsync(db, id).execute().get()
        name += anime.name
        author += anime.author
        year += anime.year
        episodes += anime.episodes
        genry += anime.genry
        rating += anime.rating
        description += anime.description
        onGoing += onGoingValue(anime.onGoing)
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetAsync(var db:AppDatabase, var id:Int) : AsyncTask<Unit, Unit, Anime>() {
        override fun doInBackground(vararg params: Unit?): Anime {
            return db.animeDao().findById(id)
        }
    }

    private fun onGoingValue(on:Boolean): String {
        if (on){
            return "Active"
        }
        return "Complete"
    }
}