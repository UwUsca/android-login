package com.example.login

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChangeInfos : AppCompatActivity() {

    lateinit var newUsernameInput : EditText
    lateinit var newPasswordInput : EditText
    lateinit var changeBtn : Button

    fun showDialog(context: Context, title: String, message: String){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_infos)

        newUsernameInput = findViewById(R.id.user_change_input)
        newPasswordInput = findViewById(R.id.pass_change_input)
        changeBtn = findViewById(R.id.change_btn)

        changeBtn.setOnClickListener{

            val newUsername = newUsernameInput.text.toString()
            val newPassword = newPasswordInput.text.toString()

            if(newUsername.isNotBlank() && newPassword.isNotBlank()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", newUsername)
                intent.putExtra("password", newPassword)
                startActivity(intent)
                finish()
            } else {
                showDialog(this@ChangeInfos, "Dados inválidos", "Dados não podem ser vazios")
            }

        }

    }
}