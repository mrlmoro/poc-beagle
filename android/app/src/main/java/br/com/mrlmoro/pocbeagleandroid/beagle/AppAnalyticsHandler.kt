package br.com.mrlmoro.pocbeagleandroid.beagle

import android.util.Log
import br.com.zup.beagle.analytics.Analytics
import br.com.zup.beagle.analytics.ClickEvent
import br.com.zup.beagle.analytics.ScreenEvent
import br.com.zup.beagle.annotation.BeagleComponent

@BeagleComponent
class AppAnalyticsHandler : Analytics {

    override fun sendClickEvent(event: ClickEvent) {
        Log.i("ANALYTICS_EVENT", event.toString())
    }

    override fun sendViewWillAppearEvent(event: ScreenEvent) {
        Log.i("ANALYTICS_SCREEN", "Appear: $event")
    }

    override fun sendViewWillDisappearEvent(event: ScreenEvent) {
        Log.i("ANALYTICS_SCREEN", "Disappear: $event")
    }

}