package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Game::class, Console::class], version = 1)

abstract class SmGamesDb: RoomDatabase(){
    abstract fun smGamesDao():SmGamesDao

    companion object{
        private lateinit var instance:SmGamesDb

        fun getDataBase(context: Context):SmGamesDb{
            if(!::instance.isInitialized){
                instance = Room.databaseBuilder(context, SmGamesDb::class.java, "db_social_media_games").allowMainThreadQueries().build()
            }

            return instance
        }
    }
}