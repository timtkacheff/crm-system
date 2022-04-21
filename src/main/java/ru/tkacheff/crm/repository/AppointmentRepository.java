package ru.tkacheff.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tkacheff.crm.AppointmentStatus;
import ru.tkacheff.crm.entity.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("FROM Appointment A WHERE A.status = ?1")
    List<Appointment> findAllByStatus(AppointmentStatus status);
}
