package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    Date billGeneratedOn;

    private String Customer_Name;

    private double Consumption_Units;

    private String Period;

    private double Bill_Amount;

    @ManyToOne
    @JoinColumn
    private Consumer consumer;

    @ManyToOne
    @JoinColumn
    private Admin admin;

}
