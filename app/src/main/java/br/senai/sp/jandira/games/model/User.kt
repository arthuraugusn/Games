package br.senai.sp.jandira.games.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tbl_user")
class User{

    @PrimaryKey(autoGenerate = true)
    var id = 0

//    var photo: Bitmap? = null
    var email = ""
    var password = ""
    var name = ""
    var city = ""
    var birthDate = ""
    var sex = 'I' //Char é '',  1 caracter
    var console = ""
    var level: EnumLevels? = null
}