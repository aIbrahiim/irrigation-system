package com.task.irrigationsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class PlotDTO {
    private int id;
    private String name;
    private double area;
    private List<String> irrigationTimeSlots;
    private double waterAmount;
}
