package com.example.project3.services;

import com.example.project3.models.Measurement;
import com.example.project3.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorsService sensorsService) {
        this.measurementRepository = measurementRepository;
        this.sensorsService = sensorsService;
    }

    @Transactional
    public void save(Measurement measurement){
        measurement.setSensor(sensorsService.findByName(measurement.getSensor().getName()).get());
        measurementRepository.save(measurement);
    }

    public List<Measurement> findAll(){
        return measurementRepository.findAll();
    }
}
