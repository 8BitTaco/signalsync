package cs259signal;
public class Triangle extends Signal{
	@Override
	public float getSample(long us) {
		us = us%1000000;
		float usf = (float)us;
		if(us < 250000) {
			usf /= 250000.0f;
			return usf;
		} else if(us <= 750000) {
			usf /= 250000.0f;
			usf -=2.0f;
			return usf;
		} else if(us <= 1000000) {
			usf -= 750000.0f;
			usf /= 250000.0f;
			return 1.0f - usf; 
		} else {
			return 0.0f;
		}
	}
}