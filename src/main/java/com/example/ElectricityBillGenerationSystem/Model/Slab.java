package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="slab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double minUnit;

    private double maxUnit;

    private double Slab_Rate;

    @ManyToOne
    @JoinColumn
    private Admin admin;

//    @ManyToOne
//    @JoinColumn
//    private Consumer consumer;



}
