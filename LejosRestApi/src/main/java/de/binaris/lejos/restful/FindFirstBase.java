package de.binaris.lejos.restful;

import javax.ws.rs.core.Response;

import de.binaris.lejos.restful.api.IColorSensorInterface;
import de.binaris.lejos.restful.api.IDifferentialPilotRestService;

public class FindFirstBase {
	
	private IColorSensorInterface ev3ColorSensorRestService;
	private IDifferentialPilotRestService eV3DifferentialPilotRestService;
	
	public FindFirstBase(IColorSensorInterface ev3ColorSensorRestService, IDifferentialPilotRestService eV3DifferentialPilotRestService) {
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
