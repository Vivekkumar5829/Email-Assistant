package com.vivek.email_assistant.emailassistantservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivek.email_assistant.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmaliAssistantService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmaliAssistantService(WebClient.Builder webClient) {
        this.webClient = WebClient.builder().build();
    }

    public String generateEmailReply(EmailRequest emailRequest) {
        String prompt = buildPrompt(emailRequest);

        Map<String, Object> requestBody = Map.of("contents" , new Object[] {
                Map.of("parts" , new Object[] {
                        Map.of("text" , prompt)
                })
        });

        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-type" , "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

            return extractResponseConten(response);





    }

    private String extractResponseConten(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        }catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("Generate a professional email reply for the follwing content. Please don't generate a subject line");

        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a " ).append(emailRequest.getTone()).append("tone.");

        }
        prompt.append("\n Original email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
