package com.example.project3.dto;

import com.example.project3.models.Measurement;
import lombok.Data;

import java.util.List;

@Data
public class MeasurementResponse {

    private List<MeasurementDTO> measurements;

    public MeasurementResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
