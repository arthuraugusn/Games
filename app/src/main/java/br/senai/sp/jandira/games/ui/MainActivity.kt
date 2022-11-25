package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.UserRepository


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var consoleRepository: ConsoleRepository
    lateinit var console: Console
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar!!.hide()

        console = Console()
        userRepository = UserRepository(this)

        binding.textViewSignUp.setOnClickListener {
            var openNewAccount =Intent(this, NewAccount::class.java)

            startActivity(openNewAccount)
        }

        consoleRepository = ConsoleRepository(this)

        val arrayS = consoleRepository.getAllConsoles()

        if(arrayS.size == 0){
            saveConsole()
        }

        binding.buttonLogin.setOnClickListener{
            login()
        }
    }

    private fun login() {
        userRepository = UserRepository(this)
        val user = userRepository.getUser(binding.editTextEmailLogin.text.toString(), binding.editTextPassword.text.toString())

        if(user != null){
            val userGames = Intent(this, UserGames::class.java)
            userGames.putExtra("name", user.name)
            userGames.putExtra("email", user.email)
            userGames.putExtra("level", user.level.toString())
            startActivity(userGames)
        }
    }


    private fun saveConsole() {
        consoleRepository = ConsoleRepository(this)
        console.name = "Playstation 3"
        console.producer = "Sony"
        console.description = "O PlayStation 3 (PS3) é um console de videogames desenvolvido pela Sony Computer Entertainment."
        console.launchYear = 2008

        consoleRepository.saveConsole(console)

        console.name = "Nintendo 64"
        console.producer = "Nintendo"
        console.description = "O Nintendo 64 é um console desenvolvido pela Nintendo"
        console.launchYear = 1996

        consoleRepository.saveConsole(console)
    }
}