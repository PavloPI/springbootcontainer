package my.ppi.status

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import jakarta.servlet.http.HttpServletRequest
import my.ppi.config.ConfigFactory
import org.springframework.http.ResponseEntity
import java.util.logging.Logger

class StatusService {
    fun checkStatus(method: String, request: HttpServletRequest): ResponseEntity<ObjectNode> {
        logger.info("Status " + method + " call: " + request.requestURI)

        val mapper = ObjectMapper()
        val data = mapper.createObjectNode()
        data.put(ENVIRONMENT, ConfigFactory.getConfig().environment)
        return ResponseEntity.ok(data)
    }

    companion object {
        private val logger = Logger.getLogger(StatusAPI::class.java.name)
        private const val ENVIRONMENT = "environment"
    }
}