package cs259signal;
public class SineWave extends Signal {
	int hz;
	public void setHZ(int hetz) {
		hz = hetz; 
	}
	
	@Override
	public float getSample(long us) {
		us = us%1000000;
		float something = (float)((2 * Math.PI * hz) + us); 
		float usf = (float)(Math.sin(something));
		System.out.println(usf);
		return usf; 
	}
}