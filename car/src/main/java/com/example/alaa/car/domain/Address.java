package com.example.alaa.car.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity

@Table(name = "address")
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;




    public Address() {
    }

    public Address(Long id, String street, String city, Student student) {
        this.id = id;
        this.street = street;
        this.city = city;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +

                '}';
    }
}
