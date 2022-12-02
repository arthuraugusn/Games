package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Jogos

class JogosAdapter (val context: Context): RecyclerView.Adapter<JogosAdapter.HolderJogos>() {

    private var gamesList = listOf<Jogos>()

    fun updateGamesList(jogos: List<Jogos>){
        this.gamesList = jogos
        notifyDataSetChanged()
    }

    class HolderJogos(view: View):RecyclerView.ViewHolder(view){
        val textCompany = view.findViewById<TextView>(R.id.tv_game_company)
        val textGame = view.findViewById<TextView>(R.id.tv_game_name)
        val textGameDesc = view.findViewById<TextView>(R.id.tv_desc_game)
        val imageHolderGame = view.findViewById<ImageView>(R.id.img_games_holder)

        fun bind(jogos: Jogos){
            textCompany.text =jogos.companyName
            textGame.text = jogos.gameName
            textGameDesc.text = jogos.descriptionGame
            imageHolderGame.setImageDrawable(jogos.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderJogos {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
        return HolderJogos(view)
    }

    override fun onBindViewHolder(holder: HolderJogos, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}