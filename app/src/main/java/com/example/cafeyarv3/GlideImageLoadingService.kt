package com.example.cafeyarv3

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import ss.com.bannerslider.ImageLoadingService

class GlideImageLoadingService(context: Context) : ImageLoadingService {
    var context: Context? = null

    init {
        this.context = context
    }

    override fun loadImage(url: String?, imageView: ImageView?) {
        Glide.with(context!!).load(url).into(imageView!!)
    }

    override fun loadImage(resource: Int, imageView: ImageView?) {
        Glide.with(context!!).load(resource).into(imageView!!)
    }

    override fun loadImage(
        url: String?,
        placeHolder: Int,
        errorDrawable: Int,
        imageView: ImageView?
    ) {
        Glide.with(context!!).load(url).placeholder(placeHolder).error(errorDrawable).into(imageView!!)

    }
}