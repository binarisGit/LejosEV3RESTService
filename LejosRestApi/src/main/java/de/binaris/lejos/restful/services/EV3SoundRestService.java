package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.binaris.lejos.restful.api.ISoundRestService;
import lejos.hardware.Sound;

@Path("sound")
public class EV3SoundRestService implements ISoundRestService {

	/* (non-Javadoc)
	 * @see de.binaris.lejos.restful.services.ISoundRestService#beep()
	 */
	@GET
	@Path("beep")
	@Produces(MediaType.APPLICATION_JSON)
	public Response beep() {

		System.out.println("beep");
		Sound.beep();
		
		

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	/* (non-Javadoc)
	 * @see de.binaris.lejos.restful.services.ISoundRestService#buzz()
	 */
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
