package de.binaris.lejos.application;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import de.binaris.lejos.restful.api.DifferentPilot;

public class TheJettyInstance {

	private static Server jettyServer;

	public TheJettyInstance()  {
		try {
			createTheJettyInstance();
		} catch (Exception e) {
			try {
				jettyServer.stop();
			} catch (Exception e1) {
				System.exit(0);
			}
		}
	}


	private void createTheJettyInstance() throws Exception{
	
		System.out.println("createTheJettyInstance");

		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		
	
		
		if (jettyServer == null)
			jettyServer = new Server(8080);

		jettyServer.setHandler(context);
		
		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		// Tells the Jersey Servlet which REST service/class to load.
		Map<String, String> entryPoints = new HashMap<String, String>();
		entryPoints.put("jersey.config.server.provider.classnames", de.binaris.lejos.restful.api.DifferentPilot.class.getCanonicalName());

		jerseyServlet.setInitParameters(entryPoints);

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}

	}
	

}

