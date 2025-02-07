package com.example.test.testatracsi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.testatracsi.entities.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}