package com.space.repository;


import com.space.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

// интерфейс для связи с бд
@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

}
