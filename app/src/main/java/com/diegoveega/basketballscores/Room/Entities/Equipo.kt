package com.diegoveega.basketballscores.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Equipo",
    foreignKeys =
    arrayOf(
        ForeignKey(
            entity = Partido::class,
            parentColumns = arrayOf("Id_Partido"),
            childColumns = arrayOf("Id_Partido"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
class Equipo(
    @ColumnInfo(name = "Equipo_Name")
    val EquipoName: String,
    @ColumnInfo(name = "Equipo_Puntaje")
    val EquipoPuntaje: Int,

    //Foraneo
    @ColumnInfo(name = "Id_Partido")
    val IdPartido: Int
){
    @PrimaryKey(autoGenerate = true)
    var Id_Equipo: Int = 0
}