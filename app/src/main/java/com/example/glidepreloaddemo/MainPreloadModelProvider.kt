package com.example.glidepreloaddemo

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder

class MainPreloadModelProvider(val context: Context) : ListPreloader.PreloadModelProvider<String> {
    override fun getPreloadItems(position: Int): MutableList<String> {
        val url = PHOTO_URL + "$position"
        return mutableListOf(url)
    }

    override fun getPreloadRequestBuilder(url: String): RequestBuilder<*>? {
        return Glide.with(context)
            .load(url)
    }
}