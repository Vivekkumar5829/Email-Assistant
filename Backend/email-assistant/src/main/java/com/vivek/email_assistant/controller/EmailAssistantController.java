package com.vivek.email_assistant.controller;

import com.vivek.email_assistant.dto.EmailRequest;
import com.vivek.email_assistant.emailassistantservice.EmaliAssistantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailAssistantController {
    private final EmaliAssistantService emailService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        String response = emailService.generateEmailReply(emailRequest);
        if(response == null || response.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Too many request on the server. Try agin later");
        }
        return ResponseEntity.ok(response);
    }

}
