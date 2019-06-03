package com.diegoveega.basketballscores.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.diegoveega.basketballscores.Repository.Repository
//import com.diegoveega.basketballscores.Room.Entities.Equipo
import com.diegoveega.basketballscores.Room.Entities.Partido
//import com.diegoveega.basketballscores.Room.RoomDatabase.EquipoRoomDatabase
import com.diegoveega.basketballscores.Room.RoomDatabase.PartidoRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataBaseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    //val allEquipos : LiveData<List<Equipo>>
    val allPartidos : LiveData<List<Partido>>

    init {
        val partidoDao = PartidoRoomDatabase.getDatabase(application, viewModelScope).partidoDao()
        //val equipoDao = PartidoRoomDatabase.getDatabase(application, viewModelScope).partidoDao()
        repository = Repository(partidoDao)

        //allEquipos = repository.allEquipos
        allPartidos = repository.allPartidos
    }
    fun getOnePartido(id: Int) = viewModelScope.launch (Dispatchers.IO){
        repository.getOnePartdo(id)
    }

    fun insertPartido(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)

    }
    fun updatePartido(id: Int) = viewModelScope.launch ( Dispatchers.IO ){
        repository.updatePartido(id)

    }
    /*
    fun insertEquipo(equipo: Equipo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(equipo)

    }
*/
}