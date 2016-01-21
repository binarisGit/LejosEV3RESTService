package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lejos.robotics.navigation.DifferentialPilot;
import de.binaris.lejos.restful.api.DifferentialPilotAdapter;

@Path("differentialpilot")
public class EV3DifferentialPilotRestAdapter implements
		DifferentialPilotAdapter {

	public static final String HEADER_ACCESS="Access-Control-Allow-Origin";
	private DifferentialPilot pilot;

	public EV3DifferentialPilotRestAdapter(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	@GET
	@Path("run/{rundistance}")
	public Response run(@PathParam("rundistance") int rundistance) {
		pilot.travel(rundistance);
		return Response.status(200).header(HEADER_ACCESS, "*").build();

	}

	@GET
	@Path("stop")
	public Response stop() {
		pilot.stop();
		return Response.status(200).header(HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("quickstop")
	public Response quickstop() {
		pilot.quickStop();
		return Response.status(200).header(HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("rotate/{degree}")
	public Response rotate(@PathParam("degree") int degree) {
		pilot.rotate(degree);
		return Response.status(200).header(HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("getmovementincrement")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMovementIncrement() {
		String jsonMovementIncrement = "{\"movementincrement\": "+ pilot.getMovementIncrement() + "}";
		return Response.status(200).header(HEADER_ACCESS, "*").entity(jsonMovementIncrement).build();
	}
}