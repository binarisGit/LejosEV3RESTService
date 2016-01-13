package de.binaris.lejos.restful.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lejos.hardware.Sound;

@Path("sound")
public class EV3SoundRestService {

	@GET
	@Path("beep")
	@Produces(MediaType.APPLICATION_JSON)
	public Response beep() {

		System.out.println("beep");
		Sound.beep();

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@GET
	@Path("buzz")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buzz() {

		System.out.println("buzz");
		Sound.buzz();

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

}
