package com.example.network.api.repository

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.network.api.request.ApiService
import com.example.network.models.MoviesData

class MoviesPagingSource (private val apiService: ApiService) :
    PagingSource<Int, MoviesData>() {

    companion object{
        private const val FIRST_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, MoviesData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesData> {
        return try {
            val nextPage: Int = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.moviesList(nextPage)
            var nextPageNumber: Int? = null

            if(response.body()?.meta?.pagination?.links?.next !== null){
                val uri = Uri.parse(response.body()?.meta?.pagination?.links?.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            LoadResult.Page(data = response.body()!!.moviesData, prevKey = null, nextKey = nextPageNumber)
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}