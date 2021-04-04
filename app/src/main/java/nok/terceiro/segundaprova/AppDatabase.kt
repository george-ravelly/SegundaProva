package nok.terceiro.segundaprova

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Anime::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animeDao() : AnimeDao
}