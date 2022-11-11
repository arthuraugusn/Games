package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.SmGamesDb
import br.senai.sp.jandira.games.model.Game

class GamesRepository(context: Context) {
    private val dataBase = SmGamesDb.getDataBase(context).smGamesDao()

    fun saveGame(game: Game):Long{
        return dataBase.saveGame(game)
    }
    fun deleteGame(game: Game):Int{
        return  dataBase.deleteGame(game)
    }
    fun updateGame(game: Game):Int{
        return dataBase.updateGame(game)
    }
    fun getAllGames():List<Game>{
        return dataBase.getAllGames()
    }
    fun getGameById(id:Int):Game{
        return dataBase.getGameById(id)
    }
}