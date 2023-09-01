package com.semenchuk.core.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.toast(@StringRes stringRes: Int) {
    Toast.makeText(requireContext(), stringRes, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.snack(@StringRes stringRes: Int, view: View) {
    Snackbar.make(view, stringRes, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.snack(message: String, view: View) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.getDrawable(drawable: Int): Drawable? {
    return AppCompatResources.getDrawable(
        requireContext(),
        drawable
    )
}

fun Fragment.hideSystemUI(view: View) {
    val window = activity!!.window
    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window, view.rootView).let { controller ->
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

fun Fragment.showSystemUI(view: View) {
    val window = activity!!.window
    WindowCompat.setDecorFitsSystemWindows(window, true)
    WindowInsetsControllerCompat(window, view.rootView).show(
        WindowInsetsCompat.Type.systemBars()
    )
}

fun Fragment.hideActionBar() {
    (activity as AppCompatActivity?)?.supportActionBar?.hide()
}

fun Fragment.setFullScreenMode(view: View) {
    hideSystemUI(view)
    hideActionBar()
}