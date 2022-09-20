package com.dbappgame.challengespacex.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun View.show(show: Boolean){
    this.visibility = if (show)  View.VISIBLE else View.GONE
}

fun ImageView.loadImage(context: Context,url: String?, drawable: Drawable? = null){
    val isUrlNullOrEmpty = url.isNullOrEmpty()
    Glide.with(context)
        .load(if (isUrlNullOrEmpty)drawable else url)
        .placeholder(drawable)
        .centerCrop()
        .into(this)
}