package de.binaris.lejos.restful.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface IDifferentialPilotRestService {

	public abstract Response run(int rundistance) throws Exception;

	public abstract void stop();

	public abstract void quickstop();

	public abstract Response rotate(int degree);

	public abstract float getMovementIncrement();

}