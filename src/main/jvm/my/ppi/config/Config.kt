package my.ppi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.logging.Logger

object Config : ConfigProvider {
    private val logger = Logger.getLogger(Config::class.java.name)

    override val isDebug: Boolean

    private const val DEBUG = "debug"

    init {
        isDebug = System.getenv(DEBUG) == null || !java.lang.Boolean.FALSE.toString()
            .equals(System.getenv(DEBUG), ignoreCase = true)
    }
}

@Configuration
class ConfigFactory {
    @Bean
    fun getConfig(): ConfigProvider {
        return Config
    }
}

interface ConfigProvider {
    val isDebug: Boolean
    val environment: String
        get() = if (isDebug) "Sandbox" else "Production"
}