package com.task.irrigationsystem.controller;

import com.task.irrigationsystem.dto.PlotDTO;
import com.task.irrigationsystem.service.PlotService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;


@RunWith(MockitoJUnitRunner.class)
public class PlotControllerTest {

    @InjectMocks
    private PlotController plotController;


    @Mock
    private PlotService plotService;


    @Test
    public void testAddPlot() {
        PlotDTO plotDTO = new PlotDTO();
        plotDTO.setName("My Plot");
        plotDTO.setArea(15.0);
        plotDTO.setIrrigationTimeSlots(Arrays.asList("08:00-10:00", "13:00-15:00"));
        plotDTO.setWaterAmount(50.0);

        PlotDTO addedPlot = new PlotDTO();
        addedPlot.setId(1);
        addedPlot.setName("My Plot");
        addedPlot.setArea(15.0);
        addedPlot.setIrrigationTimeSlots(Arrays.asList("08:00-10:00", "13:00-15:00"));
        addedPlot.setWaterAmount(50.0);

        Mockito.when(plotService.addPlot(Mockito.any(PlotDTO.class))).thenReturn(addedPlot);

        ResponseEntity<PlotDTO> response = plotController.addPlot(plotDTO);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(addedPlot, response.getBody());
    }


}
