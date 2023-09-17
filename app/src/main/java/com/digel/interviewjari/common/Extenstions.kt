package com.digel.interviewjari.common

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    url: String? = null,
    @DrawableRes drawableRes: Int? = null
) {
    if (drawableRes != null) {
        Glide.with(context)
            .load(drawableRes)
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}