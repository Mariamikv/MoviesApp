package com.example.hometest.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.map
import androidx.recyclerview.widget.GridLayoutManager
import com.example.base.BaseFragment
import com.example.hometest.adapters.MoviesAdapter
import com.example.hometest.databinding.HomeFragmentBinding
import com.example.hometest.view_model.HomeViewModel
import com.example.network.models.MoviesData
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class HomeFragment: BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel = get<HomeViewModel>()
    private lateinit var moviesAdapter: MoviesAdapter

    //searchView
    private var matchedMovies: ArrayList<MoviesData> = arrayListOf()
    private var movies: ArrayList<MoviesData> = arrayListOf()

    private var searchJob: Job? = null

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        initRecyclerView()
        showSearchBar()
        checkInternetConnection()
        startSearchJob()
    }

    private fun startSearchJob() {
        movies = arrayListOf()
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.getListData()
                .map { pagingData ->
                    pagingData.map { movie ->
                    Log.d("find:   ", movie.toString())
                        movies.addAll(listOf(movie))
                    }
                }
            viewModel.getListData()
                .collectLatest {
                    moviesAdapter.submitData(it)
                }
        }
        Log.d("dataaaa", movies.toString())
    }

    private fun checkInternetConnection(){
        if (checkForInternet(requireContext())) {
            Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
            //dataFromDB()
        } else {
            Toast.makeText(requireContext(), "Disconnected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkForInternet(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            return networkInfo.isConnected
        }
    }

//    private fun dataFromDB(){
//        viewModel.read()
//        viewModel._moviesData.observe(viewLifecycleOwner) {
//            // adapters unda movargot databasedan wamogebuli datazzzzzzzzz
//            //moviesAdapter.setData(it)
//        }
//    }

    private fun showSearchBar(){
        with(binding){
            searchButton.setOnClickListener {
                title.visibility = View.GONE
                searchButton.visibility = View.GONE
                searchView.visibility = View.VISIBLE

                //searchView
                binding.searchView.isSubmitButtonEnabled = true
                search()
            }
        }
    }

    private fun search(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                startSearch(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                startSearch(newText)
                return true
            }
        })
    }

    private fun startSearch(text: String?){

        Log.d("name", text.toString())
        Log.d("moviessss", movies.toString())

        matchedMovies = arrayListOf()

        text?.let {
            movies.forEach{
                if(it.secondaryName?.contains(text, true) == true){
                    Log.d("data", it.toString())
                    matchedMovies.add(it)
                }
            }

            updateRecyclerView()
            if(matchedMovies.isEmpty()){
                Toast.makeText(context, "No match Found!", Toast.LENGTH_LONG).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView(){
        binding.moviesRecyclerView.apply {
            //moviesAdapter.submitData(matchedMovies)
            moviesAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView(){
        moviesAdapter = MoviesAdapter()
        moviesAdapter.onClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it))
        }

        binding.moviesRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = moviesAdapter
        }

        moviesAdapter.addLoadStateListener { loadState ->

            if (loadState.refresh is LoadState.Loading) {

                if (moviesAdapter.snapshot().isEmpty()) {
                    binding.progressIndicator.isVisible = true
                }
                binding.errorTextView.isVisible = false

            } else {
                binding.progressIndicator.isVisible = false

                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error

                    else -> null
                }
                error?.let {
                    if (moviesAdapter.snapshot().isEmpty()) {
                        binding.errorTextView.isVisible = true
                        binding.errorTextView.text = it.error.localizedMessage
                    }
                }

            }
        }
    }
}