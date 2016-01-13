package de.binaris.lejos.restful.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;

@Path("differentialpilot")
public class EV3DifferentialPilotRestService {

	private static DifferentialPilot pilot;

	public EV3DifferentialPilotRestService() {

		if (pilot == null) {
			pilot = new DifferentialPilot(3.2d, 3.2d, 17.9d, Motor.B, Motor.A,
					false);
		}
	}

	@GET
	@Path("run/{rundistance}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response run(@PathParam("rundistance") int rundistance)
			throws Exception {
		System.out
				.println("running endpoint wurde aufgerufen mit synchronized auf methode");

		 synchronized (pilot) {
		pilot.travel(rundistance);
		 }

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@GET
	@Path("stop")
	public void stop() {
		synchronized (pilot) {
			pilot.stop();
		}
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
