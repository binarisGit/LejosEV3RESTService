package de.binaris.lejos.restful;

import javax.ws.rs.core.Response;

import de.binaris.lejos.restful.api.ColorSensorAdapter;
import de.binaris.lejos.restful.api.DifferentialPilotAdapter;

public class FindFirstBase {
	
	private ColorSensorAdapter ev3ColorSensorRestService;
	private DifferentialPilotAdapter eV3DifferentialPilotRestService;
	
	public FindFirstBase(ColorSensorAdapter ev3ColorSensorRestService, DifferentialPilotAdapter eV3DifferentialPilotRestService) {
		this.ev3ColorSensorRestService = ev3ColorSensorRestService;
		this.eV3DifferentialPilotRestService = eV3DifferentialPilotRestService;
	}

	public Boolean isOnFirstBase() {
	
		String ev3JsonString = null;
		
		try {
			eV3DifferentialPilotRestService.run(40);
			Response ev3ColorResponse = ev3ColorSensorRestService.getcolor();
			if (ev3ColorResponse  != null ){
				ev3JsonString = ev3ColorResponse.readEntity(String.class);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ev3JsonString != null ? true : false;
	}
	
	

}
