package com.jbillote.framedata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FrameDataApiApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<FrameDataApiApplication>(*args)
        }
    }
}
