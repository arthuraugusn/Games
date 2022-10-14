package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesAdapter (val context: Context): RecyclerView.Adapter<GamesAdapter.HolderGames>() {

    private var gamesList = listOf<Games>()

    fun updateGamesList(games: List<Games>){
        this.gamesList = games
        notifyDataSetChanged()
    }

    class HolderGames(view: View):RecyclerView.ViewHolder(view){
        val textCompany = view.findViewById<TextView>(R.id.text_view_company_name)
        val textGame = view.findViewById<TextView>(R.id.text_view_game_name)
        val textGameDesc = view.findViewById<TextView>(R.id.text_view_description_game)
        val imageHolderGame = view.findViewById<ImageView>(R.id.img_view_holder)

        fun bind(games: Games){
            textCompany.text =games.companyName
            textGame.text = games.gameName
            textGameDesc.text = games.descriptionGame
            imageHolderGame.setImageDrawable(games.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGames {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
        return HolderGames(view)
    }

    override fun onBindViewHolder(holder: HolderGames, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}