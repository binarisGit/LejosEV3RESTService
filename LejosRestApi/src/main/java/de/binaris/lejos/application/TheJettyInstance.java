package de.binaris.lejos.application;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TheJettyInstance {

	private static Server jettyServer;
	private ServletContextHandler context;

	public TheJettyInstance() {
		try {
			jettyServer = new Server(8080);
			initJettyContextAndDeploy();
			startJettyServer();

			/*
			 * if (jettyServer != null) { shutDownAndStartJettyServer(); } else
			 * { createTheJettyInstance(); }
			 */

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

	private void createTheJettyInstance() throws Exception {
		jettyServer = new Server(8080);
		initJettyContextAndDeploy();
		shutDownAndStartJettyServer();
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

	private void shutDownAndStartJettyServer() {

		jettyServer.setStopTimeout(10000L);
		try {
			new Thread() {
				@Override
				public void run() {
					try {
						context.stop();
						jettyServer.stop();
						startJettyServer();
					} catch (Exception ex) {
						System.out.println("Failed to stop Jetty");
					}
				}
			}.start();
		} catch (Exception e1) {
			System.out.println("Failed to start Jetty: " + e1.getMessage());
			System.exit(0);
		}
	}

	private void initJettyContextAndDeploy() {

		context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(
				org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		// Tells the Jersey Servlet which REST service/class to load.
		Map<String, String> entryPoints = new HashMap<String, String>();
		
		String differentialPilotRestServiceName=de.binaris.lejos.restful.api.EV3DifferentialPilotRestService.class
				.getCanonicalName();
		String soundRestServiceName=de.binaris.lejos.restful.api.EV3SoundRestService.class
				.getCanonicalName();
		String colorRestServiceName=de.binaris.lejos.restful.api.EV3ColorSensorRestService.class
				.getCanonicalName();
		
		String commaSeparatedRestServiceNames= differentialPilotRestServiceName+ "," + soundRestServiceName+","+colorRestServiceName;
		
		entryPoints
				.put("jersey.config.server.provider.classnames",commaSeparatedRestServiceNames);

		jerseyServlet.setInitParameters(entryPoints);
	}
}
