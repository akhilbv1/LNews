package org.akiapps.news

import android.os.Bundle
import android.view.ViewPropertyAnimator
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        listOf(login_arrow,tvLogin).forEach {
            it.setOnClickListener {
                moveAnimation()
            }
        }
    }

    private fun moveAnimation(){
        val anim =  login_arrow.animate()
        anim.apply {
            duration = 500
            translationX(2*root.right.toFloat())
            interpolator = AccelerateInterpolator()
        }.start()
        tvLogin.animate().alpha(0f).apply {
            duration = 500
        }.start()
    }
}