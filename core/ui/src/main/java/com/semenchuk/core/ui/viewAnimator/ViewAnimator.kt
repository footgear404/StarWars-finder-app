package com.semenchuk.core.ui.viewAnimator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.LinearInterpolator

class ViewAnimator {
    fun fakeDragX(view: View, xMove: Float = -150f): ObjectAnimator {
        return ObjectAnimator.ofFloat(view, "x", 0f, xMove, 0f)
            .apply {
                duration = 1000
                interpolator = AnticipateOvershootInterpolator(1f)
                repeatCount = 1
                startDelay = 2000
            }
    }

    fun scaleWithFade(view: View, startDelayValue: Long = 0): AnimatorSet {
        val scaleY = ObjectAnimator.ofFloat(
            view,
            "scaleY", 1f, 1.1f
        ).apply {
            duration = 3000
            repeatMode = ValueAnimator.REVERSE;
            repeatCount = ObjectAnimator.INFINITE
            interpolator = AnticipateOvershootInterpolator(1f)
        }

        val scaleX = ObjectAnimator.ofFloat(
            view,
            "scaleX", 1f, 1.1f
        ).apply {
            duration = 3000
            repeatMode = ValueAnimator.REVERSE;
            repeatCount = ObjectAnimator.INFINITE
            interpolator = LinearInterpolator()
        }

        val fadeAnim = ObjectAnimator.ofFloat(
            view,
            "alpha", 1f, 0.6f
        ).apply {
            duration = 3000
            repeatMode = ValueAnimator.REVERSE;
            repeatCount = ObjectAnimator.INFINITE
            interpolator = LinearInterpolator()
        }
        return AnimatorSet().apply {
            startDelay = startDelayValue
            playTogether(scaleY, scaleX, fadeAnim)
        }
    }

    fun moveItem(view: View, x: Float = 750f, y: Float = 1900f): AnimatorSet {
        val moveAnimX: ObjectAnimator = ObjectAnimator.ofFloat(
            view,
            "x", x
        )
        moveAnimX.duration = 1300
        moveAnimX.interpolator = AnticipateOvershootInterpolator(1f)

        val moveAnimY: ObjectAnimator = ObjectAnimator.ofFloat(
            view,
            "y", y
        )
        moveAnimY.duration = 1700
        moveAnimY.interpolator = AnticipateOvershootInterpolator(1f)

        val moveSet = AnimatorSet()
        moveSet.playTogether(moveAnimX, moveAnimY)
        return moveSet
    }

    fun stopAnimation(anim: ObjectAnimator) {
        anim.reverse()
        anim.end()
    }
}
