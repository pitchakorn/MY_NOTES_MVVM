package com.example.my_notes_mvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.my_notes_mvvm.R
import com.example.my_notes_mvvm.data.model.MyNote
import com.example.my_notes_mvvm.ui.viewmodel.MyNoteViewModel
import kotlinx.android.synthetic.main.activity_add_detail_note.*

class AddDetailNoteActivity : AppCompatActivity() {

    lateinit var myNoteViewModel: MyNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_detail_note)

        myNoteViewModel = ViewModelProvider(this)[MyNoteViewModel::class.java]

        btn_save_note.setOnClickListener {
            if (edt_title.text.isEmpty() || edt_description.text.isEmpty()) {
                return@setOnClickListener
            } else {
                val myNote = MyNote(edt_title.text.trim().toString(), edt_description.text.trim().toString())
                myNoteViewModel.insert(myNote)
                finish()
            }
        }
    }
}
