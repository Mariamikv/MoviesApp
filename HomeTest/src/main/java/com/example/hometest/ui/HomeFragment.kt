package com.example.hometest.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.base.BaseFragment
import com.example.hometest.databinding.HomeFragmentBinding
import com.example.hometest.view_model.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class HomeFragment: BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel = get<HomeViewModel>()

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        viewLifecycleOwner.lifecycleScope.launch {
            observe()
        }
    }

    private suspend fun observe(){

        viewModel.getMovies().observe(viewLifecycleOwner,{
            binding.test.text = it[0].moviesData?.get(0)?.originalName.toString()

        })
    }
}