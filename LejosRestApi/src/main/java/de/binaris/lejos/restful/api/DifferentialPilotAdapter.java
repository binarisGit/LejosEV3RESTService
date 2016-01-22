package de.binaris.lejos.restful.api;

public interface DifferentialPilotAdapter {
	public abstract void run(int rundistance) throws Exception;

	public abstract void stop();

	public abstract void quickstop();

	public abstract void rotate(int degree);

	public abstract float getMovementIncrement();
}