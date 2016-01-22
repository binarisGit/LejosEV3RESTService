package de.binaris.lejos.restful.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import lejos.hardware.Sound;
import de.binaris.lejos.restful.api.SoundRestAdapter;

@Path("sound")
public class EV3SoundRestAdapter implements SoundRestAdapter {
	@GET
	@Path("beep")
	public void beep() {
		Sound.beep();
	}

	@GET
	@Path("buzz")
	public void buzz() {
		Sound.buzz();
	}
}
