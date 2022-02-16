package com.example.hometest.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.hometest.R

fun ImageView.setImageUrl(url:String){
    if(url.isNotEmpty()){
        Glide.with(context).load(url)
            .placeholder(R.drawable.image)
            .into(this)
    }
}