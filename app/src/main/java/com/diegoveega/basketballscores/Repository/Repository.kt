package com.diegoveega.basketballscores.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.diegoveega.basketballscores.Room.DAO.PartidoDAO
import com.diegoveega.basketballscores.Room.Entities.Partido

class Repository(private val PartidoDAO:PartidoDAO) {

    val allPartidos: LiveData<List<Partido>> = PartidoDAO.getAllPartido()

    @WorkerThread
    suspend fun getOnePartdo(id : Int){
        PartidoDAO.getOneBook(id)
    }

    @WorkerThread
    suspend fun insert(partido: Partido){
        PartidoDAO.insert(partido)

    }
}