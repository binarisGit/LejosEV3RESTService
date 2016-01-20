package de.binaris.lejos.restful;

import org.fest.assertions.Assertions;

import de.binaris.lejos.restful.api.IColorSensorInterface;
import de.binaris.lejos.restful.api.IDifferentialPilotRestService;

public class FindFirstBaseTestIntegration {
	
	private IColorSensorInterface ev3ColorSensorRestService;
	private IDifferentialPilotRestService eV3DifferentialPilotRestService;
	
	public FindFirstBaseTestIntegration(IColorSensorInterface ev3ColorSensorRestService, IDifferentialPilotRestService eV3DifferentialPilotRestService) {
		this.ev3ColorSensorRestService = ev3ColorSensorRestService;
		this.eV3DifferentialPilotRestService = eV3DifferentialPilotRestService;
	}
	
	public void testHarldsRunsOnTheFirstBase() {
		FindFirstBase findFirstBase = new FindFirstBase(ev3ColorSensorRestService, eV3DifferentialPilotRestService);
		
		Assertions.assertThat(findFirstBase.isOnFirstBase()).as("Should stand on FirstBase!").isEqualTo(true);	
	}

}
