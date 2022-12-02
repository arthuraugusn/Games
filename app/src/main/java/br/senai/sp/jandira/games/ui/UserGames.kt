package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.adapter.JogosAdapter
import br.senai.sp.jandira.games.dao.JogosDao
import br.senai.sp.jandira.games.databinding.ActivityUserGamesBinding
import br.senai.sp.jandira.games.repository.GamesRepository

class UserGames : AppCompatActivity() {

    private lateinit var binding: ActivityUserGamesBinding
    lateinit var gamesRepository: GamesRepository
    lateinit var rvGames: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserGamesBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar!!.hide()

        rvGames = binding.rvGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapterGames = JogosAdapter(this)

        gamesRepository = GamesRepository(this)

        adapterGames.updateGamesList(JogosDao.getGames(this))

        rvGames.adapter = adapterGames

        carregarInfosUsuario()
    }

    private fun carregarInfosUsuario() {
        val email = intent.getStringExtra("email")
        binding.emailUser.text = email.toString()
        val name = intent.getStringExtra("name")
        binding.nameUser.text = name.toString()
        val level = intent.getStringExtra("level")
        binding.levelUser.text = level
        val idade = intent.getIntExtra("idade", 0)
        binding.tvAge.text = idade.toString()
    }
}