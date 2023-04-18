package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="reading")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int CurrentReading;

    @CreationTimestamp
    private Date ReadingDate;


    @ManyToOne
    @JoinColumn
    private Consumer consumer;

    @ManyToOne
    @JoinColumn
    private Admin admin;



}
