package com.task.irrigationsystem.repository;

import com.task.irrigationsystem.model.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IrrigationRepository extends JpaRepository<Irrigation, Integer> {
    Optional<Irrigation> findByPlotId(Integer plotId);
}