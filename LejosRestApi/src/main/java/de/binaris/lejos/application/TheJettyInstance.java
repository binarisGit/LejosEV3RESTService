package de.binaris.lejos.application;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.navigation.DifferentialPilot;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import de.binaris.lejos.restful.services.EV3ColorSensorRestService;
import de.binaris.lejos.restful.services.EV3DifferentialPilotRestService;
import de.binaris.lejos.restful.services.EV3SoundRestService;

public class TheJettyInstance {

	private static Server jettyServer;
	private ServletContextHandler context;

	public TheJettyInstance() {
		try {
			jettyServer = new Server(8080);
			initJettyContextAndDeploy();
			startJettyServer();

		} catch (Exception e) {
			try {
				context.stop();
				jettyServer.stop();
				System.out.println("JettyInstance is stopped");
			} catch (Exception e1) {
				System.out.println("Failed to stop JettyInstance");
				System.exit(0);
			}
		}
	}

	private void startJettyServer() throws Exception, InterruptedException {
		System.out.println(">>>> Start Jetty Server >>>>");

		try {
			jettyServer.start();
			jettyServer.join();

		} finally {
			jettyServer.destroy();
		}

	}

	private void initJettyContextAndDeploy() {

		ResourceConfig resourceConfig = new ResourceConfig();

		resourceConfig.register(new EV3DifferentialPilotRestService(
				new DifferentialPilot(3.2d, 3.2d, 17.9d, Motor.B, Motor.A,
						false)));
		resourceConfig.register(new EV3SoundRestService());
		resourceConfig.register(new EV3ColorSensorRestService(
				new EV3ColorSensor(SensorPort.S3)));

		context = new ServletContextHandler(ServletContextHandler.SESSIONS);

		ServletHolder servletHolder = new ServletHolder(new ServletContainer(resourceConfig));
		context.addServlet(servletHolder, "/*");

		jettyServer.setHandler(context);

	}
}
