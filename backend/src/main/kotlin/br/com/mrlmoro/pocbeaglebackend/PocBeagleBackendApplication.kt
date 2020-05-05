package br.com.mrlmoro.pocbeaglebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocBeagleBackendApplication

fun main(args: Array<String>) {
    runApplication<PocBeagleBackendApplication>(*args)
}
