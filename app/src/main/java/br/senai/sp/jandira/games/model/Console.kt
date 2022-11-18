package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_console")
class Console{
    @PrimaryKey(autoGenerate = true)
    var id = 0

    var name = ""
    var producer = ""
    var description = ""
//    var photo: Bitmap?= null
    var launchYear= 0
}
