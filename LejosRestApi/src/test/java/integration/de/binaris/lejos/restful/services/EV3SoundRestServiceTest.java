package integration.de.binaris.lejos.restful.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import de.binaris.lejos.restful.config.Config;

@RunWith(MockitoJUnitRunner.class)
public class EV3SoundRestServiceTest {
	private Client client;

	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
	}

	@Test
	public void ev3MindStorm_should_beep() {
		Response response = client.target(Config.BASE_URL + "/sound/beep").request().get(Response.class);
		assertThat("ev3mindstorm did not beep", response.getStatus(), is(equalTo(204)));
	}

	@Test
	public void ev3MindStorm_should_buzz() {
		Response response = client.target(Config.BASE_URL + "/sound/buzz").request().get(Response.class);
		assertThat("ev3mindstorm did not buzz", response.getStatus(), is(equalTo(204)));
	}
}
