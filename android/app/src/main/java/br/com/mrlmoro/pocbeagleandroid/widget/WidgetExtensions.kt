package br.com.mrlmoro.pocbeagleandroid.widget

import android.graphics.Color

fun String.toAndroidColor(): Int {
    val hexColor = if (this.startsWith("#")) this else "#$this"
    return Color.parseColor(hexColor)
}