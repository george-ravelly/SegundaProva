package nok.terceiro.segundaprova.banco

import androidx.room.Database
import androidx.room.RoomDatabase
import nok.terceiro.segundaprova.model.Anime

@Database(entities = [Anime::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animeDao() : AnimeDao
}