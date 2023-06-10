package com.task.irrigationsystem.controller;

import com.task.irrigationsystem.service.IrrigatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class IrrigatorControllerTest {
    @InjectMocks
    private IrrigatorController irrigatorController;

    @Mock
    private IrrigatorService irrigatorService;

    @Test
    public void testIrrigatePlot() {
        int plotId = 1;

        Mockito.doNothing().when(irrigatorService).irrigatePlot(Mockito.eq(plotId));

        ResponseEntity<String> response = irrigatorController.irrigatePlot(plotId);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Irrigation triggered for plot " + plotId, response.getBody());
    }
}
