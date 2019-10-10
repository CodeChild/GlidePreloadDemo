package com.example.glidepreloaddemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.util.ViewPreloadSizeProvider


class MainAdapter(val context: Context, val viewPreloadSizeProvider: ViewPreloadSizeProvider<String>) :
    RecyclerView.Adapter<MainViewHolder>(), ListPreloader.PreloadModelProvider<String> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return LIST_SIZE
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val imageView = holder.imageView
        Glide.with(context)
            .load(PHOTO_URL + "$position")
            .error(R.drawable.error)
            .into(imageView)
        viewPreloadSizeProvider.setView(imageView)
    }

    override fun getPreloadItems(position: Int): MutableList<String> {
        val url = PHOTO_URL + "$position"
        return mutableListOf(url)
    }

    override fun getPreloadRequestBuilder(url: String): RequestBuilder<*>? {
        return Glide.with(context)
            .load(url)
    }
}