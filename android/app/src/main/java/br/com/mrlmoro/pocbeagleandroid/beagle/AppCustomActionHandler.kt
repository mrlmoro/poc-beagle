package br.com.mrlmoro.pocbeagleandroid.beagle

import android.content.Context
import br.com.mrlmoro.pocbeagleandroid.common.CommonCustomActionHandler
import br.com.mrlmoro.pocbeagleandroid.movies.MoviesCustomActionHandler
import br.com.zup.beagle.action.ActionListener
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.action.CustomActionHandler
import br.com.zup.beagle.annotation.BeagleComponent

@BeagleComponent
class AppCustomActionHandler : CustomActionHandler {

    override fun handle(context: Context, action: CustomAction, listener: ActionListener) {
        when {
            action.name.verifyType("common") ->
                CommonCustomActionHandler().handle(context, action, listener)

            action.name.verifyType("movies") ->
                MoviesCustomActionHandler().handle(context, action, listener)
        }
    }

    private fun String.verifyType(type: String) =
        split(":").firstOrNull() == type

}