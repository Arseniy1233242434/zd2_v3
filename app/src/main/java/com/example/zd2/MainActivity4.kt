package com.example.zd2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.zd2.R.*
import com.example.zd2.R.id.*
import com.example.zd2.presentation.AppDatabase
import com.example.zd2.presentation.Item

class MainActivity4 : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var Add: Button
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main4)
        editText = findViewById(R.id.editText)
        Add = findViewById(R.id.Add)
        database = Room.databaseBuilder(this, AppDatabase::class.java, "base")
            .allowMainThreadQueries().build()
        Add.setOnClickListener {
            val text = editText.text.toString().trim()
            if (text.isNotEmpty()) {

                val item = Item(name = text)
                database.itemDao().insert(item)
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
        }

    }
}