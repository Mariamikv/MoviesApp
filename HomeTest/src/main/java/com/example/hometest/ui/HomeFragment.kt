package com.example.hometest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.base.BaseFragment
import com.example.hometest.databinding.HomeFragmentBinding

class HomeFragment: BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){

    }
}