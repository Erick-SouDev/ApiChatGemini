package erick.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import erick.dev.service.ConnectionServicesGeminiApi;

@RestController
@RequestMapping("/ia")
public class ControllerChatGemini {

    @Autowired
    private ConnectionServicesGeminiApi connectionServicesGeminiApi;

    @PostMapping("/responde")
    public ResponseEntity<String> send(@RequestBody String message) throws JsonProcessingException {

        return ResponseEntity.ok().body(this.connectionServicesGeminiApi.sendMessageGemini(message));
    }
}
