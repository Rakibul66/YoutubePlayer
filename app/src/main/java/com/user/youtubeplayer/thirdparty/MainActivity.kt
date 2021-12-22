package com.user.youtubeplayer.thirdparty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.user.youtubeplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding= ActivityMainBinding.inflate(layoutInflater)
            val view=binding.root
            setContentView(view)
            binding.thirdPartyPlayer.getPlayerUiController().showFullscreenButton(true)
            binding.thirdPartyPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                    val videoId = "YE7VzlLtp-4"
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })

            binding.thirdPartyPlayer.getPlayerUiController().setFullScreenButtonClickListener(View.OnClickListener {
                if (binding.thirdPartyPlayer.isFullScreen()) {
                    binding.thirdPartyPlayer.exitFullScreen()
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
                    // Show ActionBar
                    if (supportActionBar != null) {
                        supportActionBar!!.show()
                    }
                } else {
                    binding.thirdPartyPlayer.enterFullScreen()
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                    // Hide ActionBar
                    if (supportActionBar != null) {
                        supportActionBar!!.hide()
                    }
                }
            })
    }
}