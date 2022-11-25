package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.SmGamesDb
import br.senai.sp.jandira.games.model.User

class UserRepository(context: Context) {

    val dataBase = SmGamesDb.getDataBase(context).smGamesDao()

    fun saveUser(user: User):Long{
        return dataBase.saveUser(user)
    }
    fun deleteUser(user: User):Int{
        return  dataBase.deleteUser(user)
    }
    fun updateUser(user: User):Int{
        return dataBase.updateUser(user)
    }
    fun getUser(email: String, password: String):User{
        return  dataBase.getUser(email, password)
    }
}