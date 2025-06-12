package com.bugrahankaramollaoglu.spotify_interface

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SongAdapter
    private lateinit var songList: List<SongModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        songList = listOf(
            SongModel("album1", "Black Star", "David Bowie"),
            SongModel("album2", "Imagine", "John Lennon"),
            SongModel("album1", "Bohemian Rhapsody", "Queen")
        )

        adapter = SongAdapter(songList)
        recyclerView.adapter = adapter


    }
}