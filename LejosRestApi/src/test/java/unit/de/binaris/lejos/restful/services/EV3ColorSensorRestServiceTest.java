package unit.de.binaris.lejos.restful.services;

import static org.mockito.Mockito.verify;
import lejos.hardware.sensor.EV3ColorSensor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.binaris.lejos.restful.services.EV3ColorSensorRestAdapter;

@RunWith(MockitoJUnitRunner.class)
public class EV3ColorSensorRestServiceTest {
	// SUT
	@InjectMocks
	private EV3ColorSensorRestAdapter ev3ColorSensorRestService;
	@Mock
	private EV3ColorSensor ev3ColorSensor;

	@Test
	public void should_call_getColor() {
		ev3ColorSensorRestService.getColor();
		verify(ev3ColorSensor).getColorID();
	}
}
