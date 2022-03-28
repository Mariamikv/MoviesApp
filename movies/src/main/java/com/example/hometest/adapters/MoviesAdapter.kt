package com.example.hometest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hometest.databinding.MoviesListLayoutBinding
import com.example.hometest.extensions.setImageUrl
import com.example.network.models.Movies
import com.example.network.models.MoviesData

class MoviesAdapter: PagingDataAdapter<MoviesData, MoviesAdapter.MoviesViewHolder>(DiffUtilCallBack()) {

    private var onClick: ((data: MoviesData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val dataHolder = MoviesListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position)!!, onClick!!)
    }

    class MoviesViewHolder(private val binding: MoviesListLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: MoviesData, onClick: (moviesData: MoviesData) -> Unit){
            with(binding){
                binding.data = data

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

    fun onClickListener(onClick: (data: MoviesData) -> Unit){
        this.onClick = onClick
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<MoviesData>(){
        override fun areItemsTheSame(oldItem: MoviesData, newItem: MoviesData): Boolean {
            return oldItem.secondaryName == newItem.secondaryName
        }

        override fun areContentsTheSame(oldItem: MoviesData, newItem: MoviesData): Boolean {
            return oldItem == newItem
        }
    }
}