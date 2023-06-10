package com.task.irrigationsystem.service.impl;

import com.task.irrigationsystem.model.Plot;
import com.task.irrigationsystem.repository.PlotRepository;
import com.task.irrigationsystem.service.PlotService;
import com.task.irrigationsystem.dto.PlotDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlotServiceImpl implements PlotService {


    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    ModelMapper modelMapper;


    public PlotDTO addPlot(PlotDTO plotDTO) {
        Plot plot = modelMapper.map(plotDTO, Plot.class);
        Plot savedPlot = plotRepository.save(plot);
        return modelMapper.map(savedPlot, PlotDTO.class);
    }

    public PlotDTO configurePlot(int id, PlotDTO plotDTO) {
        Optional<Plot> optionalPlot = plotRepository.findById(id);
        if (optionalPlot.isPresent()) {
            Plot plot = optionalPlot.get();
            updatePlotFromDTO(plot, plotDTO);
            Plot updatedPlot = plotRepository.save(plot);
            return modelMapper.map(updatedPlot, PlotDTO.class);
        } else {
           throw new EntityNotFoundException();
        }
    }

    public PlotDTO editPlot(int id, PlotDTO plotDTO) {
        Optional<Plot> optionalPlot = plotRepository.findById(id);
        if (optionalPlot.isPresent()) {
            Plot plot = optionalPlot.get();
            updatePlotFromDTO(plot, plotDTO);
            Plot updatedPlot = plotRepository.save(plot);
            return modelMapper.map(updatedPlot, PlotDTO.class);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<PlotDTO> getAllPlots() {
        List<Plot> plots = plotRepository.findAll();
        return plots.stream().map((element) -> modelMapper.map(element, PlotDTO.class))
                .collect(Collectors.toList());
    }

    private void updatePlotFromDTO(Plot plot, PlotDTO plotDTO) {
        if (plotDTO.getName() != null) {
            plot.setName(plotDTO.getName());
        }
        if (plotDTO.getArea() != 0) {
            plot.setArea(plotDTO.getArea());
        }
        if (plotDTO.getIrrigationTimeSlots() != null) {
            plot.setIrrigationTimeSlots(plotDTO.getIrrigationTimeSlots());
        }
        if (plotDTO.getWaterAmount() > 0) {
            plot.setWaterAmount(plotDTO.getWaterAmount());
        }
    }


}
