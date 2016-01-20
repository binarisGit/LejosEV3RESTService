package de.binaris.lejos.restful;

import javax.ws.rs.core.Response;

import org.fest.assertions.Assert;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import de.binaris.lejos.restful.services.EV3ColorSensorRestService;
import de.binaris.lejos.restful.services.EV3DifferentialPilotRestService;

public class FindFirstBaseTest {
	
	//SUT
	private FindFirstBase findFirstBase;
	
	private EV3ColorSensorRestService ev3ColorSensorRestService;
	private EV3DifferentialPilotRestService eV3DifferentialPilotRestService;
	
	@Before
	public void setUp() throws Exception {
		ev3ColorSensorRestService = Mockito.mock(EV3ColorSensorRestService.class);
		eV3DifferentialPilotRestService = Mockito.mock(EV3DifferentialPilotRestService.class);
		this.findFirstBase = new FindFirstBase(ev3ColorSensorRestService, eV3DifferentialPilotRestService);
	}
	
	@Test
	public void harald_run_from_homebase_and_finds_first_base_result_red() throws Exception {
		Response response = Mockito.mock(Response.class);
		String jsonRed = "{\"color\":6}";
		Mockito.when(response.readEntity(String.class)).thenReturn(jsonRed);
		Mockito.when(ev3ColorSensorRestService.getcolor()).thenReturn(response);
		Mockito.when(eV3DifferentialPilotRestService.run(40)).thenReturn(response);
		
		
		Boolean onFirstBase = findFirstBase.isOnFirstBase();
		
		Mockito.verify(eV3DifferentialPilotRestService, Mockito.atLeastOnce()).run(40);
		Mockito.verify(ev3ColorSensorRestService, Mockito.atLeastOnce()).getcolor();
		Mockito.verify(response, Mockito.atLeastOnce()).readEntity(String.class);
		
		Assertions.assertThat(response.readEntity(String.class)).as("Should bei red json! : " + jsonRed).isEqualTo(jsonRed);	
		Assertions.assertThat(onFirstBase).as("Should stand on HomeBase!").isEqualTo(true);	
	}

}
