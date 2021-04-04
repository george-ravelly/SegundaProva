package nok.terceiro.segundaprova

import androidx.room.*

@Dao
interface AnimeDao {
    @Query("SELECT * FROM tabela_anime")
    fun getAll(): List<Anime>

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