package com.diegoveega.basketballscores.Room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.diegoveega.basketballscores.Room.Entities.Equipo
import com.diegoveega.basketballscores.Room.Entities.Partido

interface EquipoDAO {

    @Query("SELECT * FROM Equipo where Id_Equipo =:id")
    suspend fun getOneEquipo(id: Int) : Equipo

    @Query("SELECT * FROM Equipo order by Id_Equipo")
    fun getAllEquipo(): LiveData<List<Equipo>>

    @Insert
    suspend fun insert(equipo : Equipo)

    @Query("DELETE FROM Equipo")
    fun deleteAllEquipo()
}