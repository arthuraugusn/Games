package br.senai.sp.jandira.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityNewAccountBinding

class NewAccount : AppCompatActivity() {

    private lateinit var binding: ActivityNewAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save){
            Toast.makeText(this, "salvo", Toast.LENGTH_SHORT).show()
            return true
        }
        return true
    }

    //Cria o menu (onCreateMenu)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

}