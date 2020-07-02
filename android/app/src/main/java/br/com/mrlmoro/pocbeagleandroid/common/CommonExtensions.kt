package br.com.mrlmoro.pocbeagleandroid.common

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

fun Context.showDialog(message: String) {
    if (this is AppCompatActivity) {
        DefaultDialogFragment()
            .apply {
                arguments = Bundle().apply {
                    putString(DefaultDialogFragment.MESSAGE_KEY, message)
                }
            }
            .show(supportFragmentManager, DefaultDialogFragment.TAG)
    }
}

fun Context.dismissDialog() {
    if (this is AppCompatActivity) {
        val frag = supportFragmentManager.findFragmentByTag(DefaultDialogFragment.TAG)
        if (frag is DefaultDialogFragment && frag.isAdded) {
            frag.dismissAllowingStateLoss()
        }
    }
}