package com.example.hometest.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.base.BaseFragment
import com.example.hometest.databinding.FragmentDetailsBinding
import com.example.hometest.extensions.setImageUrl


class DetailsFragment: BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    private val args: DetailsFragmentArgs by navArgs()

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){
        with(binding){
            title.text = args.data?.secondaryName.toString()
            args.data?.posters?.postersData?.x240?.let { image.setImageUrl(it) }
            description.text = args.data?.plot?.plotData?.description.toString()
            imdb.text = args.data?.imdbUrl.toString()
            imdb.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(args.data?.imdbUrl))
                startActivity(browserIntent)
            }

            playMovie.setOnClickListener {
                // send movies play url
                findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToPlayMovieFragment(args.data?.imdbUrl))
            }
        }
    }
}