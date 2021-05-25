package org.akiapps.news.extensions

import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.akiapps.news.R

object GlideUtils {



    fun getRoundedCornerOption(rad:Int) = RequestOptions()
        .centerCrop()
        .transform(RoundedCorners(rad.dpToPx()))


    val roundedCornerOption = RequestOptions()
        .centerCrop()
        .transform(RoundedCorners(15.dpToPx()))
}