package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesAdapter(val context: Context):RecyclerView.Adapter<GamesAdapter.HolderGames>() {
    private var gamesList = listOf<Game>()

    fun updateGamesList(newGamesList: List<Game>){
        this.gamesList = newGamesList
        notifyDataSetChanged()
    }

    class HolderGames(view: View):RecyclerView.ViewHolder(view){
        val tvGameName = view.findViewById<TextView>(R.id.tv_game_name)
        val tvGameComapny = view.findViewById<TextView>(R.id.tv_game_company)
        val tvGameDescription = view.findViewById<TextView>(R.id.tv_desc_game)

        fun bind(games: Game){
            tvGameComapny.text = games.studio
            tvGameDescription.text = games.description
            tvGameName.text = games.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGames {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
        return HolderGames(view)
    }

    override fun onBindViewHolder(holder: HolderGames, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return  gamesList.size
    }
}