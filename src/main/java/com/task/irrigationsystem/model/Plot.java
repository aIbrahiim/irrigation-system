package com.task.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "plots")
@Setter
@Getter
@NoArgsConstructor
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double area;
    @ElementCollection
    @CollectionTable(name = "plot_irrigation_time_slots", joinColumns = @JoinColumn(name = "plot_id"))
    @Column(name = "time_slot")
    private List<String> irrigationTimeSlots;
    private double waterAmount;


}
