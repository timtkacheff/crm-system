package ru.tkacheff.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tkacheff.crm.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
