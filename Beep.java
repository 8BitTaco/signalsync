package cs259signal;
public class Beep {
	public static void playBeep(String signalType, int pitch, float duration) {
		Square s1 = new Square(0.5f);
		Sawtooth sw = new Sawtooth();
		Triangle tr = new Triangle();
		SineWave sn = new SineWave(); 
		try {
		int drMicro = (int) (duration*1000000);
		if(signalType.equalsIgnoreCase("triangle")) {
			Modulator md = new Modulator(tr);
			md.setPeriod(pitch);
			Envelope ev = new Envelope(md, 100000, 5000, 0.0f, 5000); 
			ev.setDuration(drMicro);
			WavePlay.play(ev, drMicro);
		} else if(signalType.equalsIgnoreCase("square")) {
			Modulator md = new Modulator(s1);
			md.setPeriod(pitch);
			Envelope ev = new Envelope(md, 10000, 500, 0.0f, 5000); 
			ev.setDuration(drMicro);
			WavePlay.play(ev, drMicro);
		} else if(signalType.equalsIgnoreCase("sawtooth")) {
			Modulator md = new Modulator(sw);
			md.setPeriod(pitch);
			Envelope ev = new Envelope(md, 1000, 500, 0.0f, 5000); 
			ev.setDuration(drMicro);
			WavePlay.play(ev, drMicro);
		} else if(signalType.equalsIgnoreCase("sine")) {
			Modulator md = new Modulator(sn);
			md.setPeriod(pitch);
			sn.setHZ(pitch);
			Envelope ev = new Envelope(md, 1000, 500, 0.0f, 5000); 
			ev.setDuration(drMicro);
			WavePlay.play(ev, drMicro);
		}
		} catch(Exception e) {
			System.out.println("Something went wrong!");
			System.out.println("Remember the format is: <waveform name> <pitch> <duration>");
			System.out.println("Think about what you did");
			System.exit(0);
		}
		
	}

}
