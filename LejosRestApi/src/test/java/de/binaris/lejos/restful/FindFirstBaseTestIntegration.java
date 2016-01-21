package de.binaris.lejos.restful;

import org.fest.assertions.Assertions;

import de.binaris.lejos.restful.api.ColorSensorAdapter;
import de.binaris.lejos.restful.api.DifferentialPilotAdapter;

public class FindFirstBaseTestIntegration {
	
	private ColorSensorAdapter ev3ColorSensorRestService;
	private DifferentialPilotAdapter eV3DifferentialPilotRestService;
	
	public FindFirstBaseTestIntegration(ColorSensorAdapter ev3ColorSensorRestService, DifferentialPilotAdapter eV3DifferentialPilotRestService) {
		this.ev3ColorSensorRestService = ev3ColorSensorRestService;
		this.eV3DifferentialPilotRestService = eV3DifferentialPilotRestService;
	}
	
	public void testHarldsRunsOnTheFirstBase() {
		FindFirstBase findFirstBase = new FindFirstBase(ev3ColorSensorRestService, eV3DifferentialPilotRestService);
		
		Assertions.assertThat(findFirstBase.isOnFirstBase()).as("Should stand on FirstBase!").isEqualTo(true);	
	}

}
