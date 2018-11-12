package cs259signal;

public class Instrument extends Signal implements Musical {
	String in;
	Signal signal;
	long attack;
	long decay; 
	float level;
	long release; 
	public Instrument(String n,Signal t,long a,long d,float slv,long r) {
		in = n;
		signal = t;
		attack = a; 
		decay = d; 
		level = slv;
		release = r;
	}

	@Override
	public void setNote(long d, int hz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Instrument getInstrument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getSample(long us) {
		// TODO Auto-generated method stub
		return 0;
	}

}
