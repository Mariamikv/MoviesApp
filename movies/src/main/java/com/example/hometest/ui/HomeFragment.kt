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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.base.BaseFragment
import com.example.hometest.adapters.MoviesAdapter
import com.example.hometest.databinding.HomeFragmentBinding
import com.example.hometest.view_model.HomeViewModel
import com.example.network.models.MoviesData
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class HomeFragment: BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel = get<HomeViewModel>()
    private lateinit var moviesAdapter: MoviesAdapter

    //searchView
    private var matchedMovies: ArrayList<MoviesData> = arrayListOf()
    private var movies: ArrayList<MoviesData> = arrayListOf()

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        viewLifecycleOwner.lifecycleScope.launch {
            observe()
        }
        initRecyclerView()
        showSearchBar()
        checkInternetConnection()
    }

    private fun checkInternetConnection(){
        if (checkForInternet(requireContext())) {
            Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
            dataFromDB()
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

    private fun dataFromDB(){
        viewModel.read()
        viewModel._moviesData.observe(viewLifecycleOwner) {
            // adapters unda movargot databasedan wamogebuli datazzzzzzzzz
            //moviesAdapter.setData(it)
        }
    }

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
                if (query != null) {
                    Log.d("name", query)
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                startSearch(newText)
                return true
            }
        })
    }

    private fun startSearch(text: String?){
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
            moviesAdapter.setData(matchedMovies)
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
    }

    private suspend fun observe(){
        viewModel.getMovies().observe(viewLifecycleOwner) {
            moviesAdapter.setData(it.moviesData)

            //write into database
            viewModel.writeEpisode(it.moviesData?.get(0)?.secondaryName,it.moviesData?.get(0)?.plot?.plotData?.description,
                it.moviesData?.get(0)?.posters?.postersData?.x240, it.moviesData?.get(0)?.imdbUrl)
        }
    }
}