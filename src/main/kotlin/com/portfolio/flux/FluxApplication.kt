package com.portfolio.flux

import com.portfolio.flux.client.GreetingClient
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class FluxApplication{

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val context: ConfigurableApplicationContext = SpringApplication.run(FluxApplication::class.java)
			val greetingClient: GreetingClient = context.getBean(GreetingClient::class.java)

			println(">> message = " + greetingClient.getMessage().block())
		}
	}

}


