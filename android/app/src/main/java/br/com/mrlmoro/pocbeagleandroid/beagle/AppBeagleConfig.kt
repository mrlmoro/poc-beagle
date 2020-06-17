package br.com.mrlmoro.pocbeagleandroid.beagle

import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.BeagleConfig
import br.com.zup.beagle.setup.Cache
import br.com.zup.beagle.setup.Environment

const val BASE_URL = "http://192.168.0.14:8080"

@BeagleComponent
class AppBeagleConfig : BeagleConfig {

    override val baseUrl: String get() = BASE_URL

    override val environment: Environment get() = Environment.DEBUG

    override val cache: Cache get() = Cache(
        enabled = true,
        maxAge = 300,
        memoryMaximumCapacity = 20
    )
}