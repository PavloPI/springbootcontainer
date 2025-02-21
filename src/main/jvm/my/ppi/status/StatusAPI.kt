package my.ppi.status

import com.fasterxml.jackson.databind.node.ObjectNode
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/status")
class StatusAPI {
    val service = StatusService();

    @GetMapping(produces = ["application/json"])
    fun getCheckStatus(request: HttpServletRequest): ResponseEntity<ObjectNode> {
        return service.checkStatus("GET", request)
    }

    @PostMapping(produces = ["application/json"])
    fun postCheckStatus(request: HttpServletRequest): ResponseEntity<ObjectNode> {
        return service.checkStatus("POST", request)
    }

    @PutMapping(produces = ["application/json"])
    fun putCheckStatus(request: HttpServletRequest): ResponseEntity<ObjectNode> {
        return service.checkStatus("PUT", request)
    }

    @DeleteMapping(produces = ["application/json"])
    fun deleteCheckStatus(request: HttpServletRequest): ResponseEntity<ObjectNode> {
        return service.checkStatus("DELETE", request)
    }
}