package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    //Mappings

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Consumer> ConsumerList = new ArrayList<>();

    @OneToMany(mappedBy ="admin", cascade = CascadeType.ALL)
    private List<Reading> readingList = new ArrayList<>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Slab> slabList=new ArrayList<>();


    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<Bill> billList = new ArrayList<>();


}
