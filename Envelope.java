package cs259signal;
public class Envelope extends Signal {
	int ak;
	int dc;
	float st;
	int rl;
	int sust;
	Signal sg;
	public Envelope() {}
	
	public Envelope(Signal signal, int attack, int decay, float sustain, int release) {
		ak = attack;
		dc = decay;
		st = sustain;
		rl = release; 
		sg = signal; 
	}
	
	public void setDuration(int time) {
		sust = time - ak - dc - rl;
		if(sust < 0)
			throw new IllegalArgumentException("Sustain can't be negative!"); 
	}
	
	@Override
	public float getSample(long us) {
		if(us < ak) {
			return (float)(((us / ak) * 2) - 1); 
		} else if (us < (ak + dc)){
			return (float)(((us / (ak + dc) * (-2)) + 2)); 
		} else if(us < (ak + dc + sust)) {
			return sg.getSample(us); 
		} else if(us < (ak + dc + sust + rl)) {
			float x = (float)(us - (ak + dc + sust)) / (rl);
			float y = (float) Math.pow(x, 2);
			y *= -1;
			return y;
		} else {
			return 0.0f; 
		}
	}

}
