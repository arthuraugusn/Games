package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.buttonLogin.setOnClickListener{
            var openGames = Intent(this, UserGames::class.java)

            startActivity(openGames)
        }

        binding.textViewSignUp.setOnClickListener {
            var openNewAccount =Intent(this, NewAccount::class.java)

            startActivity(openNewAccount)
        }
    }
}