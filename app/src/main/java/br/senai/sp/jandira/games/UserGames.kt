package br.senai.sp.jandira.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.dao.GamesDao
import br.senai.sp.jandira.games.databinding.ActivityUserGamesBinding

class UserGames : AppCompatActivity() {

    private lateinit var binding: ActivityUserGamesBinding
    lateinit var rvGames: RecyclerView
    lateinit var adapterGames:GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserGamesBinding.inflate(layoutInflater)

        rvGames =binding.rvGames

        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)

        adapterGames.updateGamesList(GamesDao.getGames(this))

        setContentView(binding.root)

        supportActionBar!!.hide()

        rvGames.adapter = adapterGames
    }
}