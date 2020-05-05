package br.com.mrlmoro.pocbeagleandroid.common

import android.content.Context
import br.com.mrlmoro.pocbeagleandroid.beagle.DefaultActionListener
import br.com.zup.beagle.action.ActionListener
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.action.CustomActionHandler

class CommonCustomActionHandler : CustomActionHandler {

    fun handle(context: Context, action: CustomAction) {
        handle(context, action, DefaultActionListener())
    }

    override fun handle(context: Context, action: CustomAction, listener: ActionListener) {
        when (action.name) {
            "common:openWeb" -> action.data["url"]?.run { context.openWeb(this) }

            "common:showDialog" -> action.data["message"]?.run { context.showDialog(this) }

            "common:dismissDialog" -> context.dismissDialog()
        }
    }

}