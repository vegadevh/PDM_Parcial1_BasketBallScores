package com.diegoveega.basketballscores.Room

import android.content.Context
import android.nfc.Tag
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diegoveega.basketballscores.Room.DAO.PartidoDAO
import com.diegoveega.basketballscores.Room.Entities.Partido
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Tag::class, Partido::class), version = 1)
public abstract class PartidoRoomDatabase : RoomDatabase() {

    abstract fun partidoDao() : PartidoDAO

    companion object {
        @Volatile
        private var INSTANCE: PartidoRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): PartidoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidoRoomDatabase::class.java,
                    "Partido_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }




    }


}