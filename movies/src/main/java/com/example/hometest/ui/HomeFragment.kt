package com.example.hometest.ui

import android.R
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
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
            observe()
        }
        initRecyclerView()
        showSearchBar()
    }

    private fun showSearchBar(){

        with(binding){
            searchButton.setOnClickListener {
                title.visibility = View.GONE
                searchButton.visibility = View.GONE
                searchView.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView(){
        moviesAdapter = MoviesAdapter()
        moviesAdapter.onClickListener {
            // move on details fragment
        }

        binding.moviesRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = moviesAdapter
        }
    }

    private suspend fun observe(){
        viewModel.getMovies().observe(viewLifecycleOwner) {
            moviesAdapter.setData(it.moviesData)
        }
    }
}