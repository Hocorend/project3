package com.example.project3.util;

import com.example.project3.dto.SensorDTO;
import com.example.project3.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    public void validate(Object target, Errors errors){
        SensorDTO sensorDTO = (SensorDTO) target;
        if(sensorsService.findByName(sensorDTO.getName()).isPresent()){
            errors.rejectValue("name","Уже есть сенсор с таким именем");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
