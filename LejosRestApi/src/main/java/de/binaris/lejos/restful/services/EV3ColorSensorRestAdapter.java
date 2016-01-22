package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
	public int getColor() {
		return ev3ColorSensor.getColorID();
	}
}
