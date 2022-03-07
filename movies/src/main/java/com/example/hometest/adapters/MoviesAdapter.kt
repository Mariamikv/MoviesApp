package com.example.hometest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hometest.databinding.MoviesListLayoutBinding
import com.example.hometest.extensions.setImageUrl
import com.example.network.models.Movies
import com.example.network.models.MoviesData

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var moviesData = mutableListOf<MoviesData>()
    private var onClick: ((data: MoviesData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val dataHolder = MoviesListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = holder.bind(moviesData[position], onClick!!)

    override fun getItemCount(): Int  = moviesData.size

    class MoviesViewHolder(private val binding: MoviesListLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: MoviesData, onClick: (moviesData: MoviesData) -> Unit){
            with(binding){
                binding.data = data

                //data.genres?.genresData?.get(0)?.backgroundImage?.let { image.setImageUrl(it) }
                data.posters?.postersData?.x240.let {
                    if (it != null) {
                        image.setImageUrl(it)
                    }
                }
                root.setOnClickListener {
                    onClick.invoke(data)
                }
            }
        }
    }

    fun setData(data: List<MoviesData>?){
        moviesData.clear()
        if (data != null) {
            moviesData.addAll(data)
        }
        notifyDataSetChanged()
    }

    fun onClickListener(onClick: (data: MoviesData) -> Unit){
        this.onClick = onClick
    }
}