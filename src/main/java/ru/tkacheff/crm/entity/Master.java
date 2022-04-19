package ru.tkacheff.crm.entity;


import javax.persistence.*;

@Entity
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hourly_rate")
    private Double hourlyRate;

    public Master() {}

    public Master(String name, String phoneNumber, Double hourlyRate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.hourlyRate = hourlyRate;
    }
}
