package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.SmGamesDb
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game

class ConsoleRepository(context: Context) {
    private val dataBase = SmGamesDb.getDataBase(context).smGamesDao()

    fun saveConsole(console: Console):Long{
        return dataBase.saveConsole(console)
    }
    fun deleteConsole(console: Console):Int{
        return  dataBase.deleteConsole(console)
    }
    fun updateConsole(console: Console):Int{
        return dataBase.updateConsole(console)
    }
    fun getAllConsoles():List<String>{
        return dataBase.getAllConsoles()
    }
    fun getConsoleById(id:Int): Console {
        return dataBase.getConsoleById(id)
    }
}