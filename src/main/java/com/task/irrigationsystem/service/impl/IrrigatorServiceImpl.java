package com.task.irrigationsystem.service.impl;

import com.task.irrigationsystem.model.Irrigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.irrigationsystem.repository.IrrigationRepository;
import com.task.irrigationsystem.service.IrrigatorService;
import com.task.irrigationsystem.service.SensorDeviceService;

import java.util.Optional;

@Service
public class IrrigatorServiceImpl implements IrrigatorService {

    @Autowired
    private IrrigationRepository irrigationRepository;


    public void irrigatePlot(int plotId) {
        Optional<Irrigation> optionalIrrigation = irrigationRepository.findByPlotId(plotId);
        if (optionalIrrigation.isPresent()) {
            Irrigation irrigation = optionalIrrigation.get();
            irrigation.setStatus(true);
            irrigationRepository.save(irrigation);
        }
    }

}
