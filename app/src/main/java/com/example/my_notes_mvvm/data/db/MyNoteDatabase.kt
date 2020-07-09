package com.example.my_notes_mvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.my_notes_mvvm.data.dao.MyNoteDao
import com.example.my_notes_mvvm.data.model.MyNote

@Database(entities = [MyNote::class], version = 1)
abstract class MyNoteDatabase : RoomDatabase() {

    abstract val myNoteDao: MyNoteDao

    companion object {
        @Volatile
        private var INSTANCE: MyNoteDatabase? = null

        fun getInstance(context: Context): MyNoteDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyNoteDatabase::class.java,
                        "my_note"
                    ).build()
                }
                return instance
            }
        }

    }

}