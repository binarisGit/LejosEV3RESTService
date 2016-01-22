package unit.de.binaris.lejos.restful.services;

import static org.mockito.Mockito.verify;
import lejos.robotics.navigation.DifferentialPilot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import de.binaris.lejos.restful.services.EV3DifferentialPilotRestAdapter;

@RunWith(MockitoJUnitRunner.class)
public class EV3DifferentialPilotRestServiceTest {
	// SUT
	@InjectMocks
	private EV3DifferentialPilotRestAdapter ev3DifferentialPilotRestService;
	@Mock
	private DifferentialPilot pilot;

	@Test
	public void ev3mindstorm_should_stop() {
		ev3DifferentialPilotRestService.stop();
		verify(pilot, Mockito.times(1)).stop();
	}

	@Test
	public void ev3mindstorm_should_quickstop() {
		ev3DifferentialPilotRestService.quickstop();
		verify(pilot, Mockito.times(1)).quickStop();
	}

	@Test
	public void ev3mindstorm_should_run_5_cm() {
		ev3DifferentialPilotRestService.run(5);
		verify(pilot, Mockito.times(1)).travel(5);
	}

	@Test
	public void ev3mindstorm_should_get_movementIncrement() {
		ev3DifferentialPilotRestService.getMovementIncrement();
		verify(pilot, Mockito.times(1)).getMovementIncrement();
	}

	@Test
	public void ev3mindstorm_should_rotate_45() {
		ev3DifferentialPilotRestService.rotate(45);
		verify(pilot, Mockito.times(1)).rotate(45);
	}
}
