package integration.de.binaris.lejos.restful.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import lejos.robotics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import de.binaris.lejos.restful.config.Config;

@RunWith(MockitoJUnitRunner.class)
public class EV3ColorSensorRestServiceTest {
	private Client client;

	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
	}

	@Test
	public void ev3mindstorm_should_get_color_white() {
		Integer color = client.target(Config.BASE_URL + "/color/getcolor").request().get(Integer.class);
		assertThat("color is not white", color, is(equalTo(Color.WHITE)));
	}
}
