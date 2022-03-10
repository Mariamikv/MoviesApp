//package com.example.hometest.core.models
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//@Entity
//data class MoviesModel(
//    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    @ColumnInfo(name = "title") val title: String? = null,
//    @ColumnInfo(name = "description") val description: String? = null,
//    @ColumnInfo(name = "image") val image: String? = null,
//    @ColumnInfo(name = "imdb") val imdb: String? = null
//) {
//    constructor(title: String?, description: String?, image: String?, imdb: String?):
//            this(0, title, description, image, imdb)
//}