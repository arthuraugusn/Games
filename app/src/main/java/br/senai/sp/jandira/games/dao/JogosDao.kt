package br.senai.sp.jandira.games.dao
import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Jogos

class JogosDao {
    companion object{
        fun getGames(context: Context): List<Jogos>{
            val game = Jogos()
            game.code = 1
            game.gameName ="Shadow of The Colossus"
            game.companyName ="Sony"
            game.descriptionGame ="Shadow of the Colossus, lançado no Japão como Wander and the Colossus, é um jogo eletrônico de ação-aventura desenvolvido pela SCE Japan Studio e publicado pela Sony Computer Entertainment para o PlayStation 2."
            game.image = context.getDrawable(R.drawable.shadow)

            val game2 = Jogos()
            game2.code = 2
            game2.gameName ="Undertale"
            game2.companyName ="Sony"
            game2.descriptionGame ="Undertale é um RPG eletrônico criado pelo desenvolvedor independente norte-americano Toby Fox. No jogo, o jogador pode controlar uma criança humana que caiu em uma caverna, uma região grande e isolada sob a superfície da Terra, separada por uma barreira mágica."
            game2.image = context.getDrawable(R.drawable.undertale)

            val game3 = Jogos()
            game3.code = 3
            game3.gameName ="Stardew Valley"
            game3.companyName ="ConcernedApe"
            game3.descriptionGame ="Stardew Valley é um jogo de videogame, dos gêneros RPG e simulação, desenvolvido por Eric Barone e publicado pela ConcernedApe e pela Chucklefish. O jogo foi lançado para Microsoft Windows em 26 de fevereiro de 2016. Versões para Mac OS X e Linux foram lançadas em 29 de julho de 2016."
            game3.image = context.getDrawable(R.drawable.stardew_valley)

            val game4 = Jogos()
            game4.code = 4
            game4.gameName ="The Last of Us Part II"
            game4.companyName ="Sony"
            game4.descriptionGame ="The Last of Us Part II é um jogo eletrônico de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É o segundo jogo da franquia e foi lançado em 19 de junho de 2020 exclusivamente para PlayStation 4."
            game4.image = context.getDrawable(R.drawable.the_last)

            val game5 = Jogos()
            game5.code = 5
            game5.gameName ="Stray"
            game5.companyName ="BlueTwelve Studio"
            game5.descriptionGame ="Stray é um jogo eletrônico de aventura desenvolvido pela BlueTwelve Studio e publicado pela Annapurna Interactive. Foi lançado em 19 de julho de 2022 para Microsoft Windows, PlayStation 4 e PlayStation 5."
            game5.image = context.getDrawable(R.drawable.stray)

            val game6 = Jogos()
            game6.code = 6
            game6.gameName ="Black"
            game6.companyName ="Electronic Arts"
            game6.descriptionGame ="Black é um jogo eletrônico de tiro em primeira pessoa desenvolvido pela Criterion Games e publicado pela Electronic Arts para PlayStation 2 e Xbox. O jogo é notável por sua ação altamente estilizada, bem como por sua qualidade de som e foco em efeitos destrutivos durante o jogo."
            game6.image = context.getDrawable(R.drawable.black)


            val games = listOf<Jogos>(game, game2, game3, game4, game5, game6)
            return games
        }
    }
}