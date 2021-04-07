package nok.terceiro.segundaprova.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_anime")
data class Anime(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo val name:String?,
    @ColumnInfo val author:String?,
    @ColumnInfo val year: Int?,
    @ColumnInfo val episodes: Int?,
    @ColumnInfo val genry:String?,
    @ColumnInfo val rating: Double,
    @ColumnInfo val description: String?,
    @ColumnInfo var onGoing: Boolean = false){

}