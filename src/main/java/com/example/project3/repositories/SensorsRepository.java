package com.example.project3.repositories;

import com.example.project3.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface SensorsRepository extends JpaRepository <Sensor, Integer> {

    Optional <Sensor> findByName(String name);
}
