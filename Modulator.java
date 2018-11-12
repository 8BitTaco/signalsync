package cs259signal;
public class Modulator extends Signal {
	int htz; 
	Signal sign; 
	int counter = 0;
	public Modulator(Signal sg) { sign = sg; }
	
	public void setPeriod(int hz) { htz = hz; }
	
	@Override
	public float getSample(long us) {
		return sign.getSample(us * htz);
	}
}