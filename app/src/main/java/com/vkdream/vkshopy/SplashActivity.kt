package com.vkdream.vkshopy

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import com.vkdream.vkshopy.databinding.ActivitySplashBinding
import com.vkdream.vkshopy.ui.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(100)
            binding.iv.startAnimation(
                AnimationUtils.loadAnimation(
                    applicationContext,
                    R.anim.slide_up_in
                )
            )
        }
        lifecycleScope.launch {
            delay(100)
            binding.v1.startAnimation(
                AnimationUtils.loadAnimation(
                    applicationContext,
                    R.anim.slide_left_in
                )
            )
        }
        lifecycleScope.launch {
            delay(100)
            binding.v2.startAnimation(
                AnimationUtils.loadAnimation(
                    applicationContext,
                    R.anim.slide_right_in
                )
            )
        }
        lifecycleScope.launch {
            delay(100)
            binding.tvAppName.startAnimation(
                AnimationUtils.loadAnimation(
                    applicationContext,
                    R.anim.bounce_in_bottom
                )
            )
        }
        lifecycleScope.launch {
            delay(100)
            binding.tvSlogan.startAnimation(
                AnimationUtils.loadAnimation(
                    applicationContext,
                    R.anim.slide_bottom_in
                )
            )
        }

        binding.pbDoted.startAnimation()

        lifecycleScope.launch {
            delay(3000)
            binding.pbDoted.stopAnimation()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.exitTransition = null
                window.enterTransition = null
            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            delay(500)
            finish()
        }
    }

    private fun animateRevealClose(isBack: Boolean) {
        val mAnimator =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ViewAnimationUtils.createCircularReveal(
                    binding.clContainer,
                    binding.clContainer.width / 2,
                    0,
                    binding.clContainer.height.toFloat(),
                    binding.clContainer.width / 2.toFloat()
                )
            } else {
                TODO("VERSION.SDK_INT < LOLLIPOP")
            }
        mAnimator.duration = 500
        mAnimator.interpolator = AccelerateInterpolator()
        mAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                binding.clContainer.visibility = View.INVISIBLE
                super.onAnimationEnd(animation)
                finish()
            }

            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
            }
        })
        mAnimator.start()
    }

    override fun onBackPressed() {
        animateRevealClose(true)
    }
}