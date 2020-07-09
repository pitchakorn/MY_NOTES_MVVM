package com.example.my_notes_mvvm.data.dao

import androidx.room.*
import com.example.my_notes_mvvm.data.model.MyNote

@Dao
interface MyNoteDao {

    @Insert
    fun insert(myNote: MyNote)

    @Update
    fun update(myNote: MyNote)

    @Delete
    fun delete(myNote: MyNote)

    @Query("SELECT * FROM my_note")
    fun getAllMyNotes(): List<MyNote>

}