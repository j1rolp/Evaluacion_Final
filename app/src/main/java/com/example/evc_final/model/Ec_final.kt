package com.example.evc_final.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "ec_final")
@Parcelize
data class Ec_final(
    @PrimaryKey
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height:String,
    @SerializedName("allegiance")
    val allegiance: String,
    var isFavorite: Boolean = false
) : Parcelable

fun getData(): List<Ec_final> {
    return listOf(
        Ec_final(1,"","Titan de Ataque","15m", "Eldia"),
        Ec_final(2,"","Titan de Ataque","15m", "Eldia"),
        Ec_final(3,"","Titan de Ataque","15m", "Eldia"),
        Ec_final(4,"","Titan de Ataque","15m", "Eldia"),
        Ec_final(5,"","Titan de Ataque","15m", "Eldia"),
        Ec_final(6,"","Titan de Ataque","15m", "Eldia"),
        Ec_final(7,"","Titan de Ataque","15m", "Eldia")
    )
}


