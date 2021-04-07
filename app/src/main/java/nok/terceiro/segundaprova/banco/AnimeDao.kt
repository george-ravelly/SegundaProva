package nok.terceiro.segundaprova.banco

import androidx.lifecycle.LiveData
import androidx.room.*
import nok.terceiro.segundaprova.model.Anime

@Dao
interface AnimeDao {
    @Query("SELECT * FROM tabela_anime")
    fun getAll():LiveData<List<Anime>>

    @Query("SELECT * FROM tabela_anime WHERE id = :animeId")
    fun findById(animeId: Int): Anime

    @Query("SELECT * FROM tabela_anime WHERE name LIKE :nameAnime")
    fun findByName(nameAnime: String): Anime

    @Insert
    fun insert(anime: Anime)

    @Update
    fun atualizar(anime: Anime): Int

    @Delete
    fun delete(anime: Anime)
}