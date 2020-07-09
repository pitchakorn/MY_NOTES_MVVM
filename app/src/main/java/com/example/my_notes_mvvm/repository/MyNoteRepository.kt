package com.example.my_notes_mvvm.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.example.my_notes_mvvm.data.db.MyNoteDatabase.Companion.getInstance
import com.example.my_notes_mvvm.data.model.MyNote

class MyNoteRepository(val application: Application) {

    val listNote = MutableLiveData<List<MyNote>>()

    fun insert(myNote: MyNote) {
        Insert(application, myNote).execute()
    }

    fun update(myNote: MyNote) {
        Update(application, myNote).execute()
    }

    fun delete(myNote: MyNote) {
        Delete(application, myNote).execute()
    }

    fun getAllMyNotes(): MutableLiveData<List<MyNote>> {
        listNote.value = GetMyAllNotes(application).execute().get()
        return listNote
    }

    private class Insert(val application: Application, val myNote: MyNote) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {

            getInstance(application).myNoteDao.insert(myNote)
            return null
        }

    }

    private class Update(val application: Application, val myNote: MyNote) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {

            getInstance(application).myNoteDao.update(myNote)
            return null
        }

    }

    private class Delete(val application: Application, val myNote: MyNote) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {

            getInstance(application).myNoteDao.delete(myNote)
            return null
        }

    }

    private class GetMyAllNotes(val application: Application) :
        AsyncTask<Void, Void, List<MyNote>>() {
        override fun doInBackground(vararg params: Void?): List<MyNote>? {

            return getInstance(application).myNoteDao.getAllMyNotes()
        }

    }

}