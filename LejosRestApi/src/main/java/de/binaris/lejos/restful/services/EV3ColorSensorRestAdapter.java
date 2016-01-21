package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import lejos.hardware.sensor.EV3ColorSensor;
import de.binaris.lejos.restful.api.ColorSensorAdapter;

@Path("color")
public class EV3ColorSensorRestAdapter implements ColorSensorAdapter {

	private EV3ColorSensor ev3ColorSensor;

	public EV3ColorSensorRestAdapter(EV3ColorSensor ev3ColorSensor) {

		this.ev3ColorSensor = ev3ColorSensor;
	}

	
	@GET
	@Path("getcolor")
	public Response getcolor() {

		ev3ColorSensor.setFloodlight(true);
		float[] colorFarbe = { 0 };
		ev3ColorSensor.fetchSample(colorFarbe, 0);
		Float color = Float.valueOf(colorFarbe[0]);
		ev3ColorSensor.setFloodlight(false);
		
		return Response.ok("{\"color\":" + color + "}").status(200).header("Access-Control-Allow-Origin", "*").build();
	}

}
