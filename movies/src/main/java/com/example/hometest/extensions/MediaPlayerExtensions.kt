package com.example.hometest.extensions

import android.media.MediaPlayer
import com.example.hometest.ui.PlayMovieFragment

fun MediaPlayer.seconds(): Int {
    return this.duration / PlayMovieFragment.SECOND
}

fun MediaPlayer.currentSeconds(): Int{
    return this.currentPosition / PlayMovieFragment.SECOND
}