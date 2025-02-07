package com.example.test.testatracsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.testatracsi.entities.Quote;
import com.example.test.testatracsi.service.QuoteService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/save")
    public ResponseEntity<Quote> fetchAndSaveQuote() {
        Quote res = quoteService.fetchAndSaveQuote();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Quote>> getAll() {
        List<Quote> res = quoteService.getAllQuotes();
        return ResponseEntity.ok(res);
    }
}