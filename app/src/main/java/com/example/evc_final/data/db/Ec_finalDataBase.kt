package com.example.evc_final.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.evc_final.model.Ec_final

@Database(entities = [Ec_final::class], version = 1)
abstract class Ec_finalDataBase: RoomDatabase() {
    abstract fun Ec_finalDao(): Ec_finalDao

    companion object{
        @Volatile
        private var instance: Ec_finalDataBase? = null
        fun getDatabase(context: Context):Ec_finalDataBase{
            if (instance == null){
                synchronized(this){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context): Ec_finalDataBase? {
            return Room.databaseBuilder(
                context.applicationContext,
                Ec_finalDataBase::class.java,
                "ec_final_database"
            ).build()
        }
    }
}