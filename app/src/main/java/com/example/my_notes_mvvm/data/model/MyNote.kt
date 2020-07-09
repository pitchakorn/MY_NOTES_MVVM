package com.example.my_notes_mvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_note")
class MyNote(val titleNote:String, val description: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}