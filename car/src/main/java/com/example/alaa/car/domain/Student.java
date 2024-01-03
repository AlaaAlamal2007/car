package com.example.alaa.car.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jdk.jfr.DataAmount;

import java.util.List;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

@OneToMany(mappedBy = "student",orphanRemoval = true,
cascade = CascadeType.ALL)

@Transient
private List<Subject> learningSubjects;
    public Student() {
    }


    public List<Subject> getLearningSubjects() {
        return learningSubjects;
    }

    public void setLearningSubjects(List<Subject> learningSubjects) {
        this.learningSubjects = learningSubjects;
    }

    public Long getId() {
        return id;
    }

    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
               ", learningSubjects=" + learningSubjects +
                '}';
    }

//    public void deleteStudentReference(Subject subject){
//        learningSubjects.remove(subject);
//
//
//    }
}
