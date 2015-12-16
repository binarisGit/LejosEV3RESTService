package de.binaris.lejos.restful.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;


@Path("differentpilot")
public class DifferentPilot {
	
	private DifferentialPilot pilot;
	
	public DifferentPilot() {
		if (this.pilot == null) {
			this.pilot = new DifferentialPilot(3.2d, 3.2d, 17.9d,Motor.B, Motor.A, false);
		}
	}

	@POST
	@Path("run/{rundistance}")
	public void run(@PathParam("rundistance") int rundistance) throws Exception {
		pilot.travel(rundistance);
	}

	@POST
	@Path("stop")
	public void stop() {
		pilot.stop();
	}

	@POST
	@Path("rotate/{degree}")
	public void rotate(@PathParam("degree") int degree) {
		pilot.rotate(degree);
	}

	@POST
	@Path("beep")
	public void beep() {
		Sound.beep();
	}

	@POST
	@Path("buzz")
	public void buzz() {
		Sound.buzz();
	}
}
