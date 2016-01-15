package de.binaris.lejos.restful.api;

import javax.ws.rs.GET;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;



@Path("color")
public class EV3ColorSensorRestService {
	
	private static EV3ColorSensor ev3ColorSensor;

	public EV3ColorSensorRestService() {

		if (ev3ColorSensor == null) {
			ev3ColorSensor = new EV3ColorSensor(SensorPort.S3);
		}
		
	}

	@GET
	@Path("getcolor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getcolor() throws Exception {
		System.out.println("color endpoint wurde aufgerufen");
		
		ev3ColorSensor.setFloodlight(true);
		float[] colorFarbe = { 0 };
		ev3ColorSensor.fetchSample(colorFarbe, 0);
		System.out.println("sample  " + colorFarbe[0]);
		//return Float.valueOf(colorFarbe[0]);

		return Response.ok("{\"test\":123}").status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

}
