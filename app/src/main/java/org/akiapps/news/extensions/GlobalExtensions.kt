package org.akiapps.news.extensions

import android.content.Context
import android.content.res.Resources
import android.widget.Toast

fun Context.showToast(message:String,duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}

fun Int.dpToPx(): Int {
    return ((this * Resources.getSystem().displayMetrics.density).toInt())
}

fun Float.dpToPx(): Float {
    return ((this * Resources.getSystem().displayMetrics.density))
}

fun Float.spToPx(): Float {
    return (this@spToPx * Resources.getSystem().displayMetrics.scaledDensity + 0.5f)
}

fun Int.spToPx(): Int {
    return ((this@spToPx * Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt())
}