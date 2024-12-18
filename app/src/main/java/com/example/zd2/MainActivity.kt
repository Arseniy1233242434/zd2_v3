package com.example.zd2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun Enter(view: View)
    {
        var email=findViewById<EditText>(R.id.em)
        var pass=findViewById<EditText>(R.id.pass)
        if(email.text.toString()==""||pass.text.toString()=="")
        {
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните поля!").show()
        }
        else
        {
            val sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", email.text.toString())
            editor.putString("password", pass.text.toString())
            editor.apply()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}