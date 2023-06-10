package com.task.irrigationsystem.service.impl;

import com.task.irrigationsystem.model.Plot;
import com.task.irrigationsystem.repository.PlotRepository;
import com.task.irrigationsystem.service.IrrigatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.irrigationsystem.repository.IrrigationRepository;
import com.task.irrigationsystem.service.SensorDeviceService;

import java.time.LocalTime;
import java.util.List;

@Service
public class SensorDeviceServiceImpl implements SensorDeviceService {

    @Autowired
    private IrrigationRepository irrigationRepository;

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    IrrigatorService irrigatorService;


    @Override
    public void checkAndAlert(int slotId) {
        LocalTime currentTime = LocalTime.now();
        List<Plot> plots = plotRepository.findAll();

        for (Plot plot : plots) {
            List<String> timeSlots = plot.getIrrigationTimeSlots();

            for (String timeSlot : timeSlots) {
                LocalTime plotIrrigationTime = LocalTime.parse(timeSlot); // Convert string to LocalTime
                if (currentTime.isAfter(plotIrrigationTime)) {
                    System.out.println("Plot with id " + plot.getId() + "shoud have been irrigated");
                    irrigatorService.irrigatePlot(plot.getId());
                }
            }
        }
    }
}
