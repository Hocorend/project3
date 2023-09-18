package com.example.project3.services;

import com.example.project3.models.Sensor;
import com.example.project3.repositories.SensorsRepository;
import com.example.project3.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public List<Sensor> findAll(){
        return sensorsRepository.findAll();
    }

    public Sensor findById(int id){
        return sensorsRepository.findById(id).orElseThrow(SensorNotFoundException::new);
    }

    @Transactional
    public void save(Sensor sensor){
        sensorsRepository.save(sensor);
    }
}
