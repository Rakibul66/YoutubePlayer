package com.user.youtubeplayer.webview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.user.youtubeplayer.R
import com.user.youtubeplayer.databinding.ActivityMainBinding
import com.user.youtubeplayer.databinding.ActivityWebviewBinding
@SuppressLint("SetJavaScriptEnabled")
class WebviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebviewBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.webviewPlayerView.settings.javaScriptEnabled = true
        binding.webviewPlayerView.loadUrl("https://www.youtube.com/embed/YE7VzlLtp-4")
    }
}