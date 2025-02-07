package com.example.test.testatracsi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="QUOTE")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
public class Quote {
    @Id
    @GeneratedValue(generator="QUOTE")
    @SequenceGenerator(name="QUOTE", sequenceName="SEQ_QUOTE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "LENGTH")
    private int length;

    @Column(name = "FACT",length = 500)
    private String fact;

}