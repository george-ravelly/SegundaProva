package nok.terceiro.segundaprova


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import nok.terceiro.segundaprova.model.Anime
import nok.terceiro.segundaprova.banco.AppDatabase

class MainActivity : AppCompatActivity() {
    val db : AppDatabase by lazy {
        Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "Animes"
        ).allowMainThreadQueries().build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun insert() {
        Thread {
            runOnUiThread {
                var b : Anime = db.animeDao().findById(1)
                Log.i("TESTE", b.toString())
            }
        }
    }

}