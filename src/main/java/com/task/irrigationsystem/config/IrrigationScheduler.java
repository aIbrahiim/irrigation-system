package com.task.irrigationsystem.config;

import com.task.irrigationsystem.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.task.irrigationsystem.service.SensorDeviceService;

@Component
public class IrrigationScheduler {

    @Autowired
    private SensorDeviceService sensorDeviceService;
    @Autowired
    PlotRepository plotRepository;


    @Scheduled(cron = "0 0 * * * *")
    public void checkIrrigationTimeSlots() {
        plotRepository.findAll()
                .stream()
                .forEach(plot -> sensorDeviceService.checkAndAlert(plot.getId()));

    }
}