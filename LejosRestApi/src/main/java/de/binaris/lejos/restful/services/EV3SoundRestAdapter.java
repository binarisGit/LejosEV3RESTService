package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import lejos.hardware.Sound;
import de.binaris.lejos.restful.api.SoundRestAdapter;
import de.binaris.lejos.restful.config.Config;

@Path("sound")
public class EV3SoundRestAdapter implements SoundRestAdapter {
	@GET
	@Path("beep")
	public Response beep() {
		Sound.beep();
		return Response.status(200).header(Config.HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("buzz")
	public Response buzz() {
		Sound.buzz();
		return Response.status(200).header(Config.HEADER_ACCESS, "*").build();
	}
}
