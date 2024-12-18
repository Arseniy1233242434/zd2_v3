package com.example.zd2

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.zd2.presentation.AppDatabase

class MainActivity3 : AppCompatActivity() {
    private lateinit var list: LinearLayout
    private lateinit var base: AppDatabase
    private val items = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        list = findViewById(R.id.list)
        base = Room.databaseBuilder(this, AppDatabase::class.java, "base")
            .allowMainThreadQueries().build()
        base()
        update()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun base() {
        val itemList = base.itemDao().getAll()
        items.clear()
        for (item in itemList) {
            if (!items.contains(item.name)) {
                items.add(item.name)
            }
        }
    }
    private fun update() {
        list.removeAllViews()
        for (item in items) {
            val textView = TextView(this)
            textView.text = item
            textView.setTextColor(resources.getColor(android.R.color.black))
            textView.textSize = 18f
            list.addView(textView)
        }
    }
}