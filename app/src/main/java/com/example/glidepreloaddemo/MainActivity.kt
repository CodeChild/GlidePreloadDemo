package com.example.glidepreloaddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.ViewPreloadSizeProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainAdapter
    private lateinit var preloadSizeProvider: ViewPreloadSizeProvider<String>
    private lateinit var mainPreloadModelProvider: MainPreloadModelProvider
    private lateinit var preloader: RecyclerViewPreloader<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preloadSizeProvider = ViewPreloadSizeProvider()
        mainPreloadModelProvider = MainPreloadModelProvider(this)
        mainAdapter = MainAdapter(this, preloadSizeProvider)
        preloader = RecyclerViewPreloader(
            Glide.with(this), mainAdapter, preloadSizeProvider, 20
        )
        rv_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = mainAdapter
            addOnScrollListener(preloader)
        }
    }
}
