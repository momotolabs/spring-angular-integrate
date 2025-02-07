package com.example.test.testatracsi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.test.testatracsi.entities.Quote;
import com.example.test.testatracsi.repository.QuoteRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote fetchAndSaveQuote() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://catfact.ninja/fact", String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            Quote quote = parseResponse(responseBody);
            saveQuote(quote);
            return quote;
        }

        return null;
    }

    private Quote parseResponse(String responseBody) {
        // Parse the JSON string to a Quote object
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            JsonNode node = mapper.readTree(responseBody);

            String fact = node.get("fact").asText();
            int length = node.get("length").asInt();

            return Quote.builder()
                        .length(length)
                        .fact(fact)
                        .build();
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }

    private void saveQuote(Quote quote) {
        quoteRepository.save(quote);
    }


}