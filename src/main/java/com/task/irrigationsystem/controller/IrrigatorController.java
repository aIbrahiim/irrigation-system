package com.task.irrigationsystem.controller;

import com.task.irrigationsystem.service.IrrigatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/irrigator")
public class IrrigatorController {

    private IrrigatorService irrigatorService;

    @PostMapping("/{id}/irrigate")
    public ResponseEntity<String> irrigatePlot(@PathVariable("id") int id) {
        irrigatorService.irrigatePlot(id);
        return ResponseEntity.ok("Irrigation triggered for plot " + id);
    }
}

