package com.diegoveega.basketballscores.Room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.diegoveega.basketballscores.Room.Entities.Partido

@Dao
interface PartidoDAO {

    @Query("SELECT * FROM Partido where Id_Partido =:name")
    suspend fun getOneBook(name: String) : Partido

    @Query("SELECT * FROM Partido order by Id_Partido")
    fun getAllPartido(): LiveData<List<Partido>>

    @Insert
    suspend fun insert(partido : Partido)

    @Query("DELETE FROM Partido")
    fun deleteAllPartido()
}