package com.example.hometest.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.BaseFragment
import com.example.hometest.adapters.MoviesAdapter
import com.example.hometest.databinding.HomeFragmentBinding
import com.example.hometest.view_model.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class HomeFragment: BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel = get<HomeViewModel>()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        viewLifecycleOwner.lifecycleScope.launch {
            Log.d("adsadsa", "adasdsadsad")
            observe()
        }
        initRecyclerView()
    }

    private fun initRecyclerView(){
        moviesAdapter = MoviesAdapter()
        moviesAdapter.onClickListener {
            // move on details fragment
        }

        binding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = moviesAdapter
        }
    }

    private suspend fun observe(){
        viewModel.getMovies().observe(viewLifecycleOwner,{
            Log.d("asdsadas", "111111111111111111")
            Log.d("test", it.moviesData.toString())

            moviesAdapter.setData(it)
        })
    }
}