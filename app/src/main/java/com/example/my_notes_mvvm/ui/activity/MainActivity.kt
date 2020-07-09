package com.example.my_notes_mvvm.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_notes_mvvm.R
import com.example.my_notes_mvvm.ui.adapter.ListNoteAdapter
import com.example.my_notes_mvvm.ui.viewmodel.MyNoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myNoteViewModel: MyNoteViewModel
    lateinit var listNoteAdapter: ListNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNoteViewModel = ViewModelProvider(this)[MyNoteViewModel::class.java]
        listNoteAdapter = ListNoteAdapter()

        btn_add_note.setOnClickListener {
            startActivity(Intent(this, AddDetailNoteActivity::class.java))
        }

        val dataListNote = myNoteViewModel.getAllNotes()
        dataListNote.observe(this, Observer {
            listNoteAdapter.setContentList(it)
            listNoteAdapter.notifyDataSetChanged()
            recycler_list_note.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recycler_list_note.adapter = listNoteAdapter
        })

    }

    override fun onResume() {
        myNoteViewModel.getAllNotes().value?.let { listNoteAdapter.setContentList(it) }
        listNoteAdapter.notifyDataSetChanged()
        super.onResume()
    }

}
