package de.binaris.lejos.restful.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface IColorSensorInterface {

	public abstract Response getcolor() throws Exception;

}