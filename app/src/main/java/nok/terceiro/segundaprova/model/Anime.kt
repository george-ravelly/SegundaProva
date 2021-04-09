package nok.terceiro.segundaprova.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_anime")
data class Anime(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo var name:String?,
    @ColumnInfo var author:String?,
    @ColumnInfo var year: Int?,
    @ColumnInfo var episodes: Int?,
    @ColumnInfo var genry:String?,
    @ColumnInfo var rating: Double,
    @ColumnInfo var description: String?,
    @ColumnInfo var onGoing: Boolean = false){

}