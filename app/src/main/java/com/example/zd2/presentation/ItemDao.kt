package com.example.zd2.presentation


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ItemDao {
    @Insert
    fun insert(item: Item)

    @Query("SELECT * FROM items")
    fun getAll(): List<Item>
}