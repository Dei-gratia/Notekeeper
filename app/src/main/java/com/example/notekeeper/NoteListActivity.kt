package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val fab = binding.fab

        fab.setOnClickListener{ view ->
            startActivity(Intent(this, NoteActivity::class.java))
        }

        binding.contentNoteList.listItems.layoutManager = LinearLayoutManager(this)

        binding.contentNoteList.listItems.adapter = NoteRecyclerAdapter(this, DataManager.notes, null)
    }

    override fun onResume() {
        super.onResume()
        binding.contentNoteList.listItems.adapter?.notifyDataSetChanged()
    }
}