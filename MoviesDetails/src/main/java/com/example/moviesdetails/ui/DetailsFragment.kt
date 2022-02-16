package com.example.moviesdetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.base.BaseFragment
import com.example.moviesdetails.databinding.FragmentDetailsBinding

class DetailsFragment: BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){

    }
}