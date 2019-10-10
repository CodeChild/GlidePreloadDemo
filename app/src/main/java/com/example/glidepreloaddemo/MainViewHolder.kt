package com.example.glidepreloaddemo

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView

    init {
        imageView = itemView.findViewById(R.id.image_photo)
    }
}