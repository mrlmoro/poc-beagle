package br.com.mrlmoro.pocbeagleandroid.common

import br.com.zup.beagle.android.action.Action
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.annotation.RegisterAction

@RegisterAction
data class ShowSimpleDialogAction(
    val message: String
) : Action {
    override fun execute(rootView: RootView) {
        rootView.getContext().showDialog(message)
    }
}

@RegisterAction
class DismissDialogAction : Action {
    override fun execute(rootView: RootView) {
        rootView.getContext().dismissDialog()
    }
}