package com.example.login

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button

    var usernameToEnter = "user"
    var passwordToEnter = "1234"

    fun showDialogError(context: Context){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Credenciais inválidas")
        builder.setMessage("Certifique-se que o login e senha estão corretos")
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }

    fun setUsername(newUsername: String){
        usernameToEnter = newUsername
    }
    fun setPassword(newPassword: String){
        passwordToEnter = newPassword
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        val newUsername = intent.getStringExtra("username")
        val newPassword = intent.getStringExtra("password")

        if(newUsername != null && newPassword != null){
            setUsername(newUsername)
            setPassword(newPassword)
        }

        loginBtn.setOnClickListener{
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if(username == usernameToEnter && password == passwordToEnter){
                Log.i("Test Credentials","username: $username  Password: $password")
                val intent = Intent(this, ChangeInfos::class.java)
                startActivity(intent)
            } else {
                showDialogError(this@MainActivity)
            }
        }



    }
}