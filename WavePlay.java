package cs259signal;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public final class WavePlay {
	static void play(Signal sg, int dr) throws LineUnavailableException {
		SourceDataLine sourceLine = AudioSystem.getSourceDataLine(WaveIO.FORMAT);
		sourceLine.open();
		byte[] bs = WaveIO.toByteArray(sg, dr);
		sourceLine.start();
		WaveIO.writeFully(sourceLine, bs);
		sourceLine.close();	
	}
}