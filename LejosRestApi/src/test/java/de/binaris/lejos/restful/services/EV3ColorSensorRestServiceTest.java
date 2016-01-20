package de.binaris.lejos.restful.services;

import lejos.hardware.sensor.EV3ColorSensor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EV3ColorSensorRestServiceTest {

	//SUT
	@InjectMocks
	private EV3ColorSensorRestService ev3ColorSensorRestService;

	@Mock
	private EV3ColorSensor ev3ColorSensor;
	

	@Test
	public void should_call_getColor() {

		float[] colorFarbe = { 0 };

		ev3ColorSensorRestService.getcolor();

		Mockito.verify(ev3ColorSensor).setFloodlight(true);
		Mockito.verify(ev3ColorSensor).fetchSample(colorFarbe, 0);
		Mockito.verify(ev3ColorSensor).setFloodlight(false);
	}
}
