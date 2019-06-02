package com.diegoveega.basketballscores.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Partido"/*,
    foreignKeys =
    arrayOf(
        ForeignKey(
            entity = Equipo::class,
            parentColumns = arrayOf("EquipoName"),
            childColumns = arrayOf("EquipoNameA"),
            //No es posible agregar dos childColums
            childColumns = arrayOf("EquipoNameB"),
            onDelete = ForeignKey.CASCADE
        )
    )*/
)
class Partido(
    @ColumnInfo(name = "EquipoA")
    val EquipoNameA: String,
    @ColumnInfo(name = "EquipoB")
    val EquipoNameB: String,
    @ColumnInfo(name = "PuntosA")
    val PuntosEquipoA: Int,
    @ColumnInfo(name = "PuntosA")
    val PuntosEquipoB: Int
) {
    @PrimaryKey(autoGenerate = true)
    var Id_Partido: Int = 0

}