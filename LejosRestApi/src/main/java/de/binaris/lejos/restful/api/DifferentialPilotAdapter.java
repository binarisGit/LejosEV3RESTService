package de.binaris.lejos.restful.api;

import javax.ws.rs.core.Response;

public interface DifferentialPilotAdapter {

	public abstract Response run(int rundistance) throws Exception;

	public abstract Response stop();

	public abstract Response quickstop();

	public abstract Response rotate(int degree);

	public abstract Response getMovementIncrement();

}