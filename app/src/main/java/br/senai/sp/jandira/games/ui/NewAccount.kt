package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.isEmpty
import androidx.core.view.size
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.EnumLevels
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.GamesRepository
import br.senai.sp.jandira.games.repository.UserRepository
import java.time.LocalDate
import java.time.Year

class NewAccount : AppCompatActivity() {

    private lateinit var binding: ActivityNewAccountBinding
    lateinit var userRepository: UserRepository
    lateinit var consoleRepository: ConsoleRepository
    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = User()

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

        consoleRepository = ConsoleRepository(this)

        val arrayS = consoleRepository.getAllConsoles()

        val arrayA = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayS)
        binding.spnConsole.adapter = arrayA

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
        val anoUsuario = binding.etBirthday.text.toString().substring(0, 4).toInt()
        val anoAtual = Year.now().value
        user.birthDate = anoAtual - anoUsuario
//        user.photo = null
        user.console = consoleRepository.getConsoleById(1).name
        user.level = EnumLevels.valueOf(binding.txtLevel.text.toString())
        val op = binding.rgGender!!.checkedRadioButtonId

        user.sex = op.toChar()

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