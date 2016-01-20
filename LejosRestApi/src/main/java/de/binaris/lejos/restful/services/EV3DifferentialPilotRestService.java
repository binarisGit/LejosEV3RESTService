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

	private DifferentialPilot pilot;

	public EV3DifferentialPilotRestService(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	@GET
	@Path("run/{rundistance}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response run(@PathParam("rundistance") int rundistance)
			throws Exception {
		System.out
				.println("running endpoint wurde aufgerufen mit synchronized auf methode");
		pilot.travel(rundistance);
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@GET
	@Path("stop")
	public void stop() {
		pilot.stop();
	}

	@GET
	@Path("quickstop")
	public void quickstop() {
		synchronized (pilot) {
			pilot.quickStop();
		}
	}

	@GET
	@Path("rotate/{degree}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response rotate(@PathParam("degree") int degree) {

		synchronized (pilot) {
			pilot.rotate(degree);
		}

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@GET
	@Path("getMovementIncrement")
	public float getMovementIncrement() {
		return pilot.getMovementIncrement();
	}

}
