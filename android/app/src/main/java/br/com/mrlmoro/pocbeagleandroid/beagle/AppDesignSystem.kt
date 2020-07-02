package br.com.mrlmoro.pocbeagleandroid.beagle

import br.com.mrlmoro.pocbeagleandroid.R
import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.DesignSystem

@BeagleComponent
class AppDesignSystem : DesignSystem() {

    override fun buttonStyle(id: String): Int {
        return when (id) {
            "rounded" -> R.style.AppTheme_RoundedButton
            else -> R.style.AppTheme_Button
        }
    }

    override fun textStyle(id: String): Int {
        return when (id) {
            "title" -> R.style.AppTheme_TextView_Title
            "bold" -> R.style.AppTheme_TextView_Bold
            else -> R.style.AppTheme_TextView
        }
    }

    override fun inputTextStyle(id: String): Int? {
        return super.inputTextStyle(id)
    }

    override fun toolbarStyle(id: String): Int {
        return when (id) {
            "navigation" -> R.style.AppTheme_Toolbar_Navigation
            else -> R.style.AppTheme_Toolbar
        }
    }

}