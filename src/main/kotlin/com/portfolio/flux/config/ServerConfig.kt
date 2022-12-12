package com.portfolio.flux.config

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration
import dev.miku.r2dbc.mysql.MySqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@EnableR2dbcRepositories
@Configuration
internal class ServerConfig : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return MySqlConnectionFactory.from(
                MySqlConnectionConfiguration.builder()
                        .host("127.0.0.1").password("1234").port(3306).database("flux").username("root").build()
        )
    }
}