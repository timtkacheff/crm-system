package ru.tkacheff.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tkacheff.crm.entity.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer> {

}
