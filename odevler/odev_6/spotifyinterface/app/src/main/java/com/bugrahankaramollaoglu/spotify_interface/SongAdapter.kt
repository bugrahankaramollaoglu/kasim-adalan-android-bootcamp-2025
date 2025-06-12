package com.bugrahankaramollaoglu.spotify_interface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val songList: List<SongModel>) :
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val songImage: ImageView = itemView.findViewById(R.id.imageViewSong)
        val songTitle: TextView = itemView.findViewById(R.id.titleText)
        val songSinger: TextView = itemView.findViewById(R.id.singerText)
        val playButton: ImageView = itemView.findViewById(R.id.playButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songList[position]

        val context = holder.itemView.context
        val imageResId = context.resources.getIdentifier(song.image, "drawable", context.packageName)
        if (imageResId != 0) {
            holder.songImage.setImageResource(imageResId)
        }

        holder.songTitle.text = song.title
        holder.songSinger.text = song.singer
    }

    override fun getItemCount(): Int = songList.size
}
