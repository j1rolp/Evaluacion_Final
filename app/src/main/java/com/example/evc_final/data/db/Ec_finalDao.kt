package com.example.evc_final.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.evc_final.model.Ec_final

@Dao
interface Ec_finalDao {
    @Query("SELECT * FROM ec_final")
    fun getFavorites():List<Ec_final>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(ec_final: Ec_final)

    @Delete
    suspend fun  borrarFavorite(ec_final: Ec_final)
}