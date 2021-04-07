package nok.terceiro.segundaprova

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.Room
import nok.terceiro.segundaprova.banco.AppDatabase
import nok.terceiro.segundaprova.model.Anime

@Suppress("DEPRECATION")
class AnimeDatabase(c: Context){
    private lateinit var animes : LiveData<List<Anime>>
    private lateinit var anime : Anime
    val db : AppDatabase by lazy {
        Room.databaseBuilder(
                c,
                AppDatabase::class.java,
                "Animes"
        ).build()
    }

    inner class Task : AsyncTask<Int?, Int?, Long>() {
        override fun doInBackground(vararg params: Int?): Long? {
            if(params[0] != null) {
                var id = params[0]
                anime = db.animeDao().findById(1)
                return 1
            }
            animes = db.animeDao().getAll()
            return 0
        }
    }


    fun listAll():LiveData<List<Anime>> {
        var task = Task()
        task.execute(0)
        return animes
    }

    fun get(id: Int): Anime {
        var task = Task()
        task.execute(id)
        return anime
    }

    private fun insert() {
//        Thread {
//            runOnUiThread{
//                db.animeDao().insert(Anime(null, "naruto2", "masashi kishimoto", 2007, 500, "Shonnen", 4.5, "o naruto pode ser duro as vezes...", false))
//            }
//        }.start()
    }
}