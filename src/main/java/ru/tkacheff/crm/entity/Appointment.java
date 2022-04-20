package ru.tkacheff.crm.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.tkacheff.crm.AppointmentStatus;

import javax.persistence.*;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Getter
    @Setter
    @OneToOne
    private Client client;

    @Getter
    @Setter
    @OneToOne
    private Master master;

    @Getter
    @Setter
    private Integer duration;

    @Getter
    @Setter
    private Double price;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public Appointment() {
    }
    @Builder
    public Appointment(Client client, Master master, Integer duration, Double price, AppointmentStatus status) {
        this.client = client;
        this.master = master;
        this.duration = duration;
        this.price = price;
        this.status = status;
    }
}
