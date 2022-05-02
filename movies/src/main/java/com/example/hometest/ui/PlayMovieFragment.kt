package com.example.hometest.ui

import android.net.Uri
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.base.BaseFragment
import com.example.hometest.databinding.PlayMovieFragmentBinding
import com.example.hometest.view_model.PlayMovieViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

@RequiresApi(Build.VERSION_CODES.O)
class PlayMovieFragment: BaseFragment<PlayMovieFragmentBinding>(PlayMovieFragmentBinding::inflate) {

    private val data: PlayMovieFragmentArgs by navArgs()
    private val viewModel = get<PlayMovieViewModel>()

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        viewLifecycleOwner.lifecycleScope.launch {
            observe(data.movieID)
        }
    }

    private suspend fun observe(id: Int){
        viewModel.playMovie(id).observe(viewLifecycleOwner){
            with(binding){
                if(it.data?.isEmpty() == true){
                    videoView.visibility = View.GONE
                    cantPlayText.visibility =View.VISIBLE
                }else{
                    cantPlayText.visibility = View.GONE
                    videoView.visibility = View.VISIBLE

                    val uri: Uri = Uri.parse(it.data?.get(0)?.files?.get(0)?.files?.get(0)?.src.toString())
                    videoView.setVideoURI(uri)
                    val mediaController = MediaController(requireContext())
                    mediaController.setAnchorView(videoView)
                    mediaController.setMediaPlayer(videoView)
                    videoView.setMediaController(mediaController)
                    videoView.start()
                }
            }
        }
    }
}