package nok.terceiro.segundaprova


import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    val db : AppDatabase by lazy {
        Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "Animes"
        ).build()
    }

    private inner class listaAnimesTask : AsyncTask<Int,Int,Int>(){
        override fun doInBackground(vararg params: Int?):Int {
            if(params[0] != null){
                var id = params[0]?.toInt()
                val anime = id?.let { db.animeDao().findById(it) }
                return 0
            }
            var a = db.animeDao().getAll()
            return 1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //insert()
        find(3)
    }

    private fun find(id: Int) {
        var task = listaAnimesTask()
        task.execute(id)
    }

    private fun insert() {
        Thread {
            runOnUiThread{
                db.animeDao().insert(Anime(null, "naruto2", "masashi kishimoto", 2007, 500, "Shonnen", 4.5, "o naruto pode ser duro as vezes...", false))
            }
        }.start()
    }
}