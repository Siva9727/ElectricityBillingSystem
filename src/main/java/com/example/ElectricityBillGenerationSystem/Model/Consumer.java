package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="consumer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "name column cannot be empty")
    private String name;

    @Email(message = "Provide valid email address")
    private String email;

    @NotNull
    @Size(min = 4, max = 20)
    private String password;

    @NotBlank
    private String city;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "mobile number should contain 10 digits")
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
