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
	public void ev3mindstorm_should_stop() {
		ev3DifferentialPilotRestService.stop();
		Mockito.verify(pilot, Mockito.times(1)).stop();

	}
	
	@Test
	public void ev3mindstorm_should_quickstop() {
		ev3DifferentialPilotRestService.quickstop();
		Mockito.verify(pilot, Mockito.times(1)).quickStop();

	}
	
	
	@Test
	public void ev3mindstorm_should_run_5_cm() {
		ev3DifferentialPilotRestService.run(5);
		Mockito.verify(pilot, Mockito.times(1)).travel(5);
		
		
		
	}
	
	@Test
	public void ev3mindstorm_should_call_getMovementIncrement_once() {
		ev3DifferentialPilotRestService.getMovementIncrement();
		Mockito.verify(pilot, Mockito.times(1)).getMovementIncrement();
	}
	
	@Test
	public void ev3mindstorm_should_rotate_45() {
		ev3DifferentialPilotRestService.rotate(45);
		Mockito.verify(pilot, Mockito.times(1)).rotate(45);
	}

	
	

}
