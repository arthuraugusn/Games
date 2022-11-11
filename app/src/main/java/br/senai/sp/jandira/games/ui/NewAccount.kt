package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.games.model.EnumLevels
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.GamesRepository
import br.senai.sp.jandira.games.repository.UserRepository
import java.time.LocalDate

class NewAccount : AppCompatActivity() {

    private lateinit var binding: ActivityNewAccountBinding
    lateinit var userRepository: UserRepository
    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = User()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save){
            save()
            return true
        }
        return true
    }

    private fun save() {
        userRepository = UserRepository(this)
        user.name = binding.etPersonName.text.toString()
        user.email = binding.etEmailSignUp.text.toString()
        user.password = binding.etPasswSignUp.text.toString()
        user.city = binding.etPersonCity.text.toString()
        user.birthDate = LocalDate.parse(binding.etBirthday.text.toString())
        user.photo = null
        user.console = null
        user.level = EnumLevels.BEGINNER
        user.sex = 'M'

        userRepository.saveUser(user)
        Toast.makeText(this, "sucessfull", Toast.LENGTH_SHORT).show()
        finish()
    }

    //Cria o menu (onCreateMenu)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

}