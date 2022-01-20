package com.example.hometest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hometest.databinding.MoviesListLayoutBinding
import com.example.network.models.Movies

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var moviesData = mutableListOf<Movies>()
    private var onClick: ((id: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val dataHolder = MoviesListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = holder.bind(moviesData[position], onClick!!)

    override fun getItemCount(): Int  = moviesData.size

    class MoviesViewHolder(private val binding: MoviesListLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Movies, onClick: (id: Int) -> Unit){
            binding.data = data
            binding.root.setOnClickListener {
                data.moviesData?.get(0)?.let { it1 -> it1.id?.let { it2 -> onClick.invoke(it2) } }
            }
        }
    }

    fun setData(data: Movies){
        moviesData.clear()
        if(data!=null){
            moviesData.addAll(listOf(data))
            notifyDataSetChanged()
        }
    }

    fun onClickListener(onClick: (id: Int) -> Unit){
        this.onClick = onClick
    }
}