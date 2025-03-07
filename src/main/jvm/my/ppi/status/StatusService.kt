package my.ppi.status

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import jakarta.servlet.http.HttpServletRequest
import my.ppi.config.ConfigProvider
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class StatusService(private val config: ConfigProvider) {

    fun checkStatus(method: String, request: HttpServletRequest): ResponseEntity<ObjectNode> {
        logger.info("Status " + method + " call: " + request.requestURI)

        val mapper = ObjectMapper()
        val data = mapper.createObjectNode()
        data.put(ENVIRONMENT, config.environment)
        return ResponseEntity.ok(data)
    }

    companion object {
        private val logger = Logger.getLogger(StatusAPI::class.java.name)
        private const val ENVIRONMENT = "environment"
    }
}