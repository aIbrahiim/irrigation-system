package com.task.irrigationsystem.service;

import com.task.irrigationsystem.dto.PlotDTO;

import java.util.List;

public interface PlotService {
    PlotDTO addPlot(PlotDTO plotDTO);

    PlotDTO configurePlot(int id, PlotDTO plotDTO);

    PlotDTO editPlot(int id, PlotDTO plotDTO);

    List<PlotDTO> getAllPlots();
}
