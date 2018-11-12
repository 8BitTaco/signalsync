package cs259signal;
/**
 * A square wave is at its lowest outside of its wave duty cycle,
 * when in the wave duty cycle, it is at its highest.
 * This wave duty cycle will last for a proportion of the period defined by pulse width.
 * 
 * If a square wave has pulse width set to 50%,
 * then half of the period is spent LOW and the other half spent HIGH
 */
public class Square extends Signal {
	private float pulseWidth = 0.5f; // 50% wave duty by default
	/**
	 * Creates a square wave with a pulse width 50% that of the period
	 */
	public Square() {}
	/**
	 * Creates a square wave with custom pulse with as a percentage of the period
	 * @param pw desired pulse width
	 */
	public Square(float pw) {
		pulseWidth = pw;
	}
	@Override
	public float getSample(long us) {
		us = us%1000000;
		long usc = (long)(1000000*pulseWidth);
		if(us < usc) {
			return -1.0f;
		} else if(us > usc) {
			return 1.0f; 
		} else {
			return 0.0f;
		}
	}
}