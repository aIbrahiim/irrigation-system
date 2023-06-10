package com.task.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "irrigation")
@Setter
@Getter
@NoArgsConstructor
public class Irrigation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;
    private int slotId;
    private boolean status;


}