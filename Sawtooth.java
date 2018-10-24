/**
 * A sawtooth wave rises linearly from its lowest point to its highest during one period.
 */
public class Sawtooth extends Signal {
	@Override
	public float getSample(long us) {
		// Implement this for a sawtooth wave that has a period of 1 second
		// Parameter us is given to you in microseconds
		us = us%1000000;
		float usf = (float)us;
		usf /= 1000000.0f;
		usf *= 2.0f;
		usf -= 1.0f;

		return usf;
	}
}
