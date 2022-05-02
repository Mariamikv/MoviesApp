package com.example.network.models.moviesModels


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("air_date")
    val airDate: Any?,
    @SerializedName("covers")
    val covers: Covers?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("episode")
    val episode: Int?,
    @SerializedName("episodes_include")
    val episodesInclude: String?,
    @SerializedName("file_will_be_added_soon")
    val fileWillBeAddedSoon: Boolean?,
    @SerializedName("files")
    val files: List<File>?,
    @SerializedName("poster")
    val poster: String?,
    @SerializedName("rating")
    val rating: Any?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("upcoming")
    val upcoming: Boolean?
)