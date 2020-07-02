package br.com.mrlmoro.pocbeagleandroid.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.BeagleConfig
import br.com.zup.beagle.android.setup.Cache
import br.com.zup.beagle.android.setup.Environment

const val BASE_URL = "http://192.168.0.14:8080"

@BeagleComponent
class AppBeagleConfig : BeagleConfig {

    override val baseUrl: String get() = BASE_URL

    override val environment: Environment get() = Environment.DEBUG

    override val isLoggingEnabled: Boolean get() = true

    override val cache: Cache get() = Cache(
        enabled = false,
        maxAge = 60,
        memoryMaximumCapacity = 20
    )
}