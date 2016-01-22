package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lejos.robotics.navigation.DifferentialPilot;
import de.binaris.lejos.restful.api.DifferentialPilotAdapter;

@Path("differentialpilot")
public class EV3DifferentialPilotRestAdapter implements DifferentialPilotAdapter {
	private DifferentialPilot pilot;

	public EV3DifferentialPilotRestAdapter(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	@GET
	@Path("run/{rundistance}")
	public void run(@PathParam("rundistance") int rundistance) {
		pilot.travel(rundistance);
	}

	@GET
	@Path("stop")
	public void stop() {
		pilot.stop();
	}

	@GET
	@Path("quickstop")
	public void quickstop() {
		pilot.quickStop();
	}

	@GET
	@Path("rotate/{degree}")
	public void rotate(@PathParam("degree") int degree) {
		pilot.rotate(degree);
	}

	@GET
	@Path("getmovementincrement")
	@Produces(MediaType.TEXT_PLAIN)
	public float getMovementIncrement() {
		return pilot.getMovementIncrement();
	}
}