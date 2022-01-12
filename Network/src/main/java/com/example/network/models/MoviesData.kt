package com.example.network.models


import com.google.gson.annotations.SerializedName

data class MoviesData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("adjaraId")
    val adjaraId: Int?,
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("budget")
    val budget: String?,
    @SerializedName("canBePlayed")
    val canBePlayed: Boolean?,
    @SerializedName("countries")
    val countries: Countries?,
    @SerializedName("cover")
    val cover: Cover?,
    @SerializedName("covers")
    val covers: Covers?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("genres")
    val genres: Genres?,
    @SerializedName("hasSubtitles")
    val hasSubtitles: Boolean?,
    @SerializedName("imdbUrl")
    val imdbUrl: String?,
    @SerializedName("income")
    val income: String?,
    @SerializedName("isFree")
    val isFree: Boolean?,
    @SerializedName("isTvShow")
    val isTvShow: Boolean?,
    @SerializedName("languages")
    val languages: Languages?,
    @SerializedName("originalName")
    val originalName: String?,
    @SerializedName("packAllowed")
    val packAllowed: Boolean?,
    @SerializedName("parentalControlRate")
    val parentalControlRate: Any?,
    @SerializedName("plot")
    val plot: Plot?,
    @SerializedName("plots")
    val plots: Plots?,
    @SerializedName("poster")
    val poster: String?,
    @SerializedName("posters")
    val posters: Posters?,
    @SerializedName("primaryName")
    val primaryName: String?,
    @SerializedName("rating")
    val rating: Rating?,
    @SerializedName("regionAllowed")
    val regionAllowed: Boolean?,
    @SerializedName("releaseDate")
    val releaseDate: String?,
    @SerializedName("secondaryName")
    val secondaryName: String?,
    @SerializedName("tertiaryName")
    val tertiaryName: String?,
    @SerializedName("trailers")
    val trailers: Trailers?,
    @SerializedName("userFollows")
    val userFollows: UserFollows?,
    @SerializedName("userSubscribed")
    val userSubscribed: UserSubscribed?,
    @SerializedName("userWantsToWatch")
    val userWantsToWatch: UserWantsToWatch?,
    @SerializedName("userWatch")
    val userWatch: UserWatch?,
    @SerializedName("watchCount")
    val watchCount: Int?,
    @SerializedName("year")
    val year: Int?
)