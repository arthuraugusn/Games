package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesAdapter (var gamesList:List<Game>, var context: Context):RecyclerView.Adapter<GamesAdapter.GamesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: GamesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class GamesHolder(view:View):RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_game_name)
    }

}