package br.com.mrlmoro.pocbeagleandroid.beagle

import br.com.zup.beagle.action.Action
import br.com.zup.beagle.action.ActionListener

class DefaultActionListener : ActionListener {
    override fun onError(e: Throwable) {}
    override fun onStart() {}
    override fun onSuccess(action: Action) {}
}