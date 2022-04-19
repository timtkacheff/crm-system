package ru.tkacheff.crm.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "phone_number")
    @Getter @Setter
    private String phoneNumber;

    @Column(name = "specialization")
    @Getter @Setter
    private String specialization;

    @Column(name = "hourly_rate")
    @Getter @Setter
    private Double hourlyRate;

    public Master() {}

    @Builder
    public Master(String name, String phoneNumber, String specialization, Double hourlyRate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
    }
}
