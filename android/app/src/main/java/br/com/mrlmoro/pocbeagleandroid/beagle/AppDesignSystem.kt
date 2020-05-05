package br.com.mrlmoro.pocbeagleandroid.beagle

import br.com.mrlmoro.pocbeagleandroid.R
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.DesignSystem

@BeagleComponent
class AppDesignSystem : DesignSystem {

    override fun buttonStyle(name: String): Int {
        return when (name) {
            "rounded" -> R.style.AppTheme_RoundedButton
            else -> R.style.AppTheme_Button
        }
    }

    override fun image(name: String): Int {
        throw IllegalArgumentException("Icon not found")
    }

    override fun tabBarStyle(name: String): Int? = null

    override fun textAppearance(name: String): Int {
        return when (name) {
            "title" -> R.style.AppTheme_TextView_Title
            "bold" -> R.style.AppTheme_TextView_Bold
            else -> R.style.AppTheme_TextView
        }
    }

    override fun theme(): Int = R.style.AppTheme

    override fun toolbarStyle(name: String): Int {
        return when (name) {
            "navigation" -> R.style.AppTheme_Toolbar_Navigation
            else -> R.style.AppTheme_Toolbar
        }
    }

}