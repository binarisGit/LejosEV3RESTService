package integration.de.binaris.lejos.restful.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import de.binaris.lejos.restful.config.Config;

@RunWith(MockitoJUnitRunner.class)
public class EV3DifferentialpilotRestServiceTest {
	private Client client;

	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
	}

	@Test
	public void ev3mindstorm_should_run_5cm() {
		Response response = client.target(Config.BASE_URL + "/differentialpilot/run/5").request().get(Response.class);
		assertThat("ev3mindstorm did not run 5 cm", response.getStatus(), is(equalTo(200)));
	}

	@Test
	public void ev3mindstorm_should_stop() {
		Response response = client.target(Config.BASE_URL + "/differentialpilot/stop").request().get(Response.class);
		assertThat("ev3mindstorm did not quickstopped!", response.getStatus(), is(equalTo(200)));
	}

	@Test
	public void ev3mindstorm_should_quickstop() {
		Response response = client.target(Config.BASE_URL + "/differentialpilot/quickstop").request().get(Response.class);
		assertThat("ev3mindstorm did not stopped!", response.getStatus(), is(equalTo(200)));
	}

	@Test
	public void ev3mindstorm_should_rotate() {
		Response response = client.target(Config.BASE_URL + "/differentialpilot/rotate/90").request().get(Response.class);
		assertThat("ev3mindstorm did not rotated!", response.getStatus(), is(equalTo(200)));
	}

	@Test
	public void ev3mindstorm_should_get_movementincrement() {
		String response = client.target(Config.BASE_URL + "/differentialpilot/getmovementincrement").request().get(String.class);
		JSONObject jsonObject = new JSONObject(response);
		Double movementIncrement = jsonObject.getDouble("movementincrement");
		assertThat("movementIncrement do not match", Math.round(movementIncrement), is(equalTo(5L)));
	}
}
