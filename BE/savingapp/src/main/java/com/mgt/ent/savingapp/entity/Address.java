package com.mgt.ent.savingapp.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "add_type")
    private String addType;
    private String address1;
    private String address2;
    private String address3;
    private String postcode;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
