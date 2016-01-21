package de.binaris.lejos.restful.api;

import javax.ws.rs.core.Response;

public interface ColorSensorAdapter {
	public abstract Response getcolor() throws Exception;
}