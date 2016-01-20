package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lejos.robotics.navigation.DifferentialPilot;
import de.binaris.lejos.restful.api.IDifferentialPilotRestService;

@Path("differentialpilot")
public class EV3DifferentialPilotRestService implements
		IDifferentialPilotRestService {

	public static final String HEADER_ACCESS="Access-Control-Allow-Origin";
	private DifferentialPilot pilot;

	public EV3DifferentialPilotRestService(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	@GET
	@Path("run/{rundistance}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response run(@PathParam("rundistance") int rundistance) {
		pilot.travel(rundistance);
		return Response.status(200).header(HEADER_ACCESS, "*").build();

	}

	@GET
	@Path("stop")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stop() {
		pilot.stop();
		return Response.status(200).header(HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("quickstop")
	@Produces(MediaType.APPLICATION_JSON)
	public Response quickstop() {
		pilot.quickStop();
		return Response.status(200).header(HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("rotate/{degree}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response rotate(@PathParam("degree") int degree) {
		pilot.rotate(degree);
		return Response.status(200).header(HEADER_ACCESS, "*").build();
	}

	@GET
	@Path("getmovementincrement")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovementIncrement() {
		String jsonMovementIncrement = "{\"movementincrement\": "
				+ pilot.getMovementIncrement() + "}";
		return Response.status(200).header(HEADER_ACCESS, "*").entity(jsonMovementIncrement).build();
	}
}