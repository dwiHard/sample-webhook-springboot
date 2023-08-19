package com.example.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class WebhookController {
    private static final Logger LOGGER = Logger.getLogger(WebhookController.class.getName());
    @PostMapping("/webhook")
    public ResponseEntity<String> receiveWebhook(@RequestBody String payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Payload parsePayload = objectMapper.readValue(payload, Payload.class);
        LOGGER.info("Received webhook payload with event type "+parsePayload.getEventType()+" and action " + parsePayload);
        return ResponseEntity.ok().build();
    }
}
