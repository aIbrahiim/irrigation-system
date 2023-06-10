package com.task.irrigationsystem.controller;

import com.task.irrigationsystem.dto.PlotDTO;
import com.task.irrigationsystem.service.PlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plots")
public class PlotController {

    private PlotService plotService;

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @PostMapping
    public ResponseEntity<PlotDTO> addPlot(@RequestBody PlotDTO plotDTO) {
        PlotDTO addedPlot = plotService.addPlot(plotDTO);
        return ResponseEntity.ok(addedPlot);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlotDTO> configurePlot(@PathVariable("id") int id, @RequestBody PlotDTO plotDTO) {
        PlotDTO configuredPlot = plotService.configurePlot(id, plotDTO);
        return ResponseEntity.ok(configuredPlot);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlotDTO> editPlot(@PathVariable("id") int id, @RequestBody PlotDTO plotDTO) {
        PlotDTO editedPlot = plotService.editPlot(id, plotDTO);
        return ResponseEntity.ok(editedPlot);
    }

    @GetMapping
    public ResponseEntity<List<PlotDTO>> getAllPlots() {
        List<PlotDTO> plots = plotService.getAllPlots();
        return ResponseEntity.ok(plots);
    }
}


