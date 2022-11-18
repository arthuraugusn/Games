package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.forEach
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.EnumLevels
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.GamesRepository
import br.senai.sp.jandira.games.repository.UserRepository
import java.time.LocalDate

class NewAccount : AppCompatActivity() {

    private lateinit var binding: ActivityNewAccountBinding
    lateinit var userRepository: UserRepository
    lateinit var consoleRepository: ConsoleRepository
    lateinit var user:User
    lateinit var console: Console

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = User()
        console = Console()

        saveConsole()

        binding.txtLevel.text = EnumLevels.BEGINNER.toString()

        binding.sliderLevel.addOnChangeListener { _, value, _ ->
            if(value.toInt() == 1){
                binding.txtLevel.text = EnumLevels.BEGINNER.toString()
            }
            else if(value.toInt() == 2){
                binding.txtLevel.text = EnumLevels.BASIC.toString()
            }
            if(value.toInt() == 3){
                binding.txtLevel.text = EnumLevels.CASUAL.toString()
            }
            if(value.toInt() == 4){
                binding.txtLevel.text = EnumLevels.ADVANCED.toString()
            }
        }

        val arrayS = consoleRepository.getAllConsoles()
        val arrayA = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayS)
        binding.spnConsole.adapter = arrayA
    }

    private fun saveConsole() {
        consoleRepository = ConsoleRepository(this)
        console.name = "Playstation 3"
        console.producer = "Sony"
        console.description = "O PlayStation 3 (PS3) é um console de videogames desenvolvido pela Sony Computer Entertainment."
        console.launchYear = 2008

        consoleRepository.saveConsole(console)
        Toast.makeText(this, "save", Toast.LENGTH_SHORT).show()
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
        consoleRepository = ConsoleRepository(this)
        user.name = binding.etPersonName.text.toString()
        user.email = binding.etEmailSignUp.text.toString()
        user.password = binding.etPasswSignUp.text.toString()
        user.city = binding.etPersonCity.text.toString()
//        user.birthDate = LocalDate.parse(binding.etBirthday.text.toString())
//        user.photo = null
//        user.console = consoleRepository.getConsoleById(1)
        user.level = binding.txtLevel.toString()
        user.sex = 'M'

        userRepository.saveUser(user)
        finish()
    }

    //Cria o menu (onCreateMenu)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

}