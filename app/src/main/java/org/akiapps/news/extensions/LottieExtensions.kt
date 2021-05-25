package org.akiapps.news.extensions

import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable


fun LottieAnimationView.playLoader() {
    setAnimation("loading.json")
    repeatMode = LottieDrawable.REVERSE
    repeatCount = LottieDrawable.INFINITE
    progress = 0f
    playAnimation()
}
