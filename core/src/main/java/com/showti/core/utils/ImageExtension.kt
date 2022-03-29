package com.showti.core.utils

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.showti.core.R


fun AppCompatImageView.loadImage(url:String?) {
    val USER_AGENT = "Mozilla/5.0 (Linux; Android 11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.181 Mobile Safari/537.36"

    val glideUrl = GlideUrl(
        url,
        LazyHeaders.Builder().addHeader("User-Agent", USER_AGENT).build())

    val requestOptions = RequestOptions()
        .placeholder(R.drawable.ic_lens)
        .error(R.drawable.ic_lens)


    Glide.with(this.context)
        .applyDefaultRequestOptions(requestOptions)
        .load(glideUrl)
        .timeout(60000)
        .override(320, 480)
        .into(this)

}