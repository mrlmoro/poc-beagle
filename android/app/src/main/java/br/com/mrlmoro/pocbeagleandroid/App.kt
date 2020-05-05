package br.com.mrlmoro.pocbeagleandroid

import android.app.Application
import br.com.mrlmoro.pocbeagleandroid.beagle.BeagleSetup

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}