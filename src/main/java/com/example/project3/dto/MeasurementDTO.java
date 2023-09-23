package com.example.project3.dto;

import com.example.project3.models.Sensor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MeasurementDTO {

    @Column(name = "value")
    @Min(value = -100, message = "The permissible temperature range is from -100 to 100")
    @Max(value = 100, message = "The permissible temperature range is from -100 to 100")
    private int value;

    @Column(name = "raining")
    private boolean raining;

    @NotNull
    private SensorDTO sensor;
}
