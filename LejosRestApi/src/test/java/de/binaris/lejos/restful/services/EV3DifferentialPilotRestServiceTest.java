package de.binaris.lejos.restful.services;

import lejos.robotics.navigation.DifferentialPilot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EV3DifferentialPilotRestServiceTest {

	// SUT
	@InjectMocks
	private EV3DifferentialPilotRestService ev3DifferentialPilotRestService;
	
	
	@Mock
	private DifferentialPilot pilot;

	@Before
	public void setup() {
	}

	@Test
	public void ev3mindstorm_shoud_stop() {

		ev3DifferentialPilotRestService.stop();

		Mockito.verify(pilot, Mockito.times(1)).stop();

	}

}
