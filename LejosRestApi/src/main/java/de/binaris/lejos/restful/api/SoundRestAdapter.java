package de.binaris.lejos.restful.api;

import javax.ws.rs.core.Response;

public interface SoundRestAdapter {

	public abstract Response beep();

	public abstract Response buzz();

}