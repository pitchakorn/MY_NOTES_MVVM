package com.example.my_notes_mvvm.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.my_notes_mvvm.data.model.MyNote
import com.example.my_notes_mvvm.repository.MyNoteRepository

class MyNoteViewModel(application: Application) : AndroidViewModel(application) {

    var listNote: LiveData<List<MyNote>>
    val myNoteRepository = MyNoteRepository(application)

    init {
        listNote = myNoteRepository.listNote
    }

    fun insert(myNote: MyNote) {
        myNoteRepository.insert(myNote)
    }

    fun update(myNote: MyNote) {
        myNoteRepository.update(myNote)
    }

    fun delete(myNote: MyNote) {
        myNoteRepository.delete(myNote)
    }

    fun getAllNotes(): LiveData<List<MyNote>> {
        listNote = myNoteRepository.getAllMyNotes()
        return listNote
    }
}