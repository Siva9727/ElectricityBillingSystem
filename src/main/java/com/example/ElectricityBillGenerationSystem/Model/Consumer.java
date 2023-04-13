package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="consumer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String password;

    private String city;

    private String mobNo;


    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
    private List<Reading> readingList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Admin admin;

//    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
//    private List<Slab> slabList=new ArrayList<>();

    @OneToMany(mappedBy = "consumer",cascade = CascadeType.ALL)
    private List<Bill> billList;


}
