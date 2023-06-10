package com.task.irrigationsystem.repository;

import com.task.irrigationsystem.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Integer> {
}