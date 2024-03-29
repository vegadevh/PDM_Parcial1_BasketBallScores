package com.diegoveega.basketballscores.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Partido")
class Partido(

    //Se ingresan datos EquipoA
    @ColumnInfo(name = "EquipoA")
    val EquipoNameA: String,

    //Se ingresan datos EquipoB
    @ColumnInfo(name = "EquipoB")
    val EquipoNameB: String,

    @ColumnInfo(name = "PuntosA")
    val PuntosEquipoA: Int,
    @ColumnInfo(name = "PuntosB")
    val PuntosEquipoB: Int,
    @ColumnInfo(name = "Fav")
    val Fav: Boolean

){
    @PrimaryKey(autoGenerate = true)
    var Id_Partido: Int = 0
}