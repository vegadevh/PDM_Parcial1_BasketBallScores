package com.diegoveega.basketballscores.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Equipo")
class Equipo(
    @ColumnInfo(name = "Author_Name")
    val EquipoName: String
){
    @PrimaryKey(autoGenerate = true)
    var Id_Equipo : Int = 0
}