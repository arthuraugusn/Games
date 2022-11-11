package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

@Dao
interface SmGamesDao{

    //Insert user
    @Insert
    fun saveUser (user: User): Long

    //Delete user
    @Delete
    fun deleteUser(user: User):Int

    //Update user
    @Update
    fun updateUser(user: User):Int

    //Insert console
    @Insert
    fun saveConsole(console: Console): Long

    //Delete console
    @Delete
    fun deleteConsole (console: Console): Int

    //Update console
    @Update
    fun updateConsole (console: Console):Int

    //Insert game
    @Insert
    fun saveGame (game: Game): Long

    //Deleta game
    @Delete
    fun deleteGame (game: Game): Int

    //Update game
    @Update
    fun updateGame (game: Game): Int

    //Mostra todos os jogos de forma ascendente
    @Query ("select * from tbl_game order by title asc")
    fun getAllGames():List<Game>

    //Busca um jogo pelo id
    @Query("select * from tbl_game where id = :id")
    fun getGameById(id:Int): Game

    //Mostra todos os consoles de forma ascendente
    @Query("select * from tbl_console order by name asc")
    fun getAllConsoles():List<Console>

    //Busca console pelo id
    @Query("select * from tbl_console where id = :id")
    fun getConsoleById(id:Int): Console
}