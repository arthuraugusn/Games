package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_game")
class Game{
    @PrimaryKey(autoGenerate = true)
    var id = 0

    var photo: Bitmap? = null
    var title = ""
    var description = ""
    var studio = ""
    var launchYear: LocalDate? = null
    var finished = Boolean
}