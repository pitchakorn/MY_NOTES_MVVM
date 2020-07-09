package com.example.my_notes_mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_notes_mvvm.R
import com.example.my_notes_mvvm.data.model.MyNote

class ListNoteAdapter() : RecyclerView.Adapter<ListNoteAdapter.MyViewHolder>() {

    lateinit var list: List<MyNote>

    fun setContentList(list: List<MyNote>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleNote = itemView.findViewById<TextView>(R.id.textView_title)
        var description = itemView.findViewById<TextView>(R.id.textView_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNoteAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_note, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListNoteAdapter.MyViewHolder, position: Int) {
        holder.titleNote.text = list[position].titleNote
        holder.description.text = list[position].description
    }
}