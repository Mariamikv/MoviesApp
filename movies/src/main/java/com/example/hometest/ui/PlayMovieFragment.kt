package com.example.hometest.ui

import android.media.MediaDrm
import android.media.MediaPlayer
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.base.BaseFragment
import com.example.hometest.R
import com.example.hometest.databinding.PlayMovieFragmentBinding
import com.example.hometest.extensions.currentSeconds
import com.example.hometest.extensions.seconds
import com.example.hometest.view_model.PlayMovieViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

@RequiresApi(Build.VERSION_CODES.O)
class PlayMovieFragment: BaseFragment<PlayMovieFragmentBinding>(PlayMovieFragmentBinding::inflate),
    SeekBar.OnSeekBarChangeListener, SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, MediaPlayer.OnDrmInfoListener {

    private val mediaPlayer = MediaPlayer()
    private lateinit var runnable: Runnable
    private var handler = Handler(Looper.getMainLooper())
    private val data: PlayMovieFragmentArgs by navArgs()

    private val viewModel = get<PlayMovieViewModel>()

    private var src: String = ""

    companion object {
        const val SECOND = 1000
    }

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        viewLifecycleOwner.lifecycleScope.launch {
            observe(data.movieID)
        }
        mediaPlayer.setOnPreparedListener(this)
        binding.videoView.holder.addCallback(this)
        binding.seekBar.setOnSeekBarChangeListener(this)
        binding.playButton.isEnabled = false

        mediaPlayer.setOnDrmInfoListener(this)

        binding.playButton.setOnClickListener {

            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                binding.playButton.setImageResource(android.R.drawable.ic_media_play)
            } else {
                mediaPlayer.start()
                binding.playButton.setImageResource(android.R.drawable.ic_media_pause)
            }
        }
    }

    private suspend fun observe(id: Int){
        viewModel.playMovie(id).observe(viewLifecycleOwner){
            Log.d("play: ", "${it.data?.get(0)?.files?.get(0)?.files?.get(0)?.src}")
            src = it.data?.get(0)?.files?.get(0)?.files?.get(0)?.src.toString()

        }
    }

    private fun timeInString(seconds: Int): String {
        return String.format(
            "%02d:%02d",
            (seconds / 3600 * 60 + ((seconds % 3600) / 60)),
            (seconds % 60)
        )
    }

    private fun initializeSeekBar() {
        binding.seekBar.max = mediaPlayer.seconds()
        binding.textProgress.text = getString(R.string.default_value)
        binding.textTotalTime.text = timeInString(mediaPlayer.seconds())
        binding.progressBar.visibility = View.GONE
        binding.playButton.isEnabled = true
    }

    private fun updateSeekBar() {
        runnable = Runnable {
            binding.textProgress.text = timeInString(mediaPlayer.currentSeconds())
            binding.seekBar.progress = mediaPlayer.currentSeconds()
            handler.postDelayed(runnable, SECOND.toLong())
        }
        handler.postDelayed(runnable, SECOND.toLong())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if (fromUser){
            mediaPlayer.seekTo(progress * SECOND)
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    override fun surfaceCreated(holder: SurfaceHolder) {
        mediaPlayer.apply {
            setOnDrmInfoListener(this@PlayMovieFragment)

            setDataSource(src)
            setDisplay(holder)
            prepareAsync()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}

    override fun onPrepared(mp: MediaPlayer?) {

        initializeSeekBar()
        updateSeekBar()
    }

    override fun onDrmInfo(mp: MediaPlayer?, drmInfo: MediaPlayer.DrmInfo?) {
        mediaPlayer.apply {
            val key = drmInfo?.supportedSchemes?.get(0)
            key?.let {
                prepareDrm(key)
                val keyRequest = getKeyRequest(
                    null, null, null,
                    MediaDrm.KEY_TYPE_STREAMING, null
                )
                provideKeyResponse(null, keyRequest.data)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        mediaPlayer.release()
        mediaPlayer.releaseDrm()
    }
}