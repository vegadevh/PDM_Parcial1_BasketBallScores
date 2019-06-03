package com.diegoveega.basketballscores.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
//import com.diegoveega.basketballscores.Room.DAO.EquipoDAO
import com.diegoveega.basketballscores.Room.DAO.PartidoDAO
//import com.diegoveega.basketballscores.Room.Entities.Equipo
import com.diegoveega.basketballscores.Room.Entities.Partido

class Repository(private val PartidoDAO:PartidoDAO/*, private val EquipoDAO: EquipoDAO*/) {

    val allPartidos: LiveData<List<Partido>> = PartidoDAO.getAllPartido()
    //val allEquipos: LiveData<List<Equipo>> = EquipoDAO.getAllEquipo()

    @WorkerThread
    suspend fun getOnePartdo(id : Int){
        PartidoDAO.getOnePartido(id)
    }

    @WorkerThread
    suspend fun insert(partido: Partido){
        PartidoDAO.insert(partido)

    }
/*
    @WorkerThread
    suspend fun getOneEquipo(id: Int){
        EquipoDAO.getOneEquipo(id)
    }

    @WorkerThread
    suspend fun insert(equipo: Equipo){
        EquipoDAO.insert(equipo)
    }

    */
}