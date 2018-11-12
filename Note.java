package cs259signal;
/**
 * A single note.
 */
public class Note {
	public static final int A = 440; // The note A above middle C, often used to tune things
	private long position; // Absolute position in time
	private long duration; // Length of time the note is to be held down
	private int pitch; // Frequency to play at
	/**
	 * Creates a new musical note.
	 * @param p position in time (microseconds)
	 * @param d duration (microseconds)
	 * @param hz pitch (in hertz / times a second)
	 */
	public Note(long p,long d,int hz) {
		position = p;
		duration = d;
		pitch = hz;
	}
	/**
	 * Checks to see if this specific absolute point in time (in microseconds) is inside of this note's duration
	 * @param us the absolute point of time (in microseconds)
	 * @return if this point in time is inside the playing of this note
	 */
	public boolean isInside(long us) {
		us = toLocalTime(us);
		return !(us < 0 || us >= duration);
	}
	/**
	 * Given the musical object, configures the object to play this note.
	 * @param mm the musical object to configure
	 */
	public void configure(Musical mm) {
		mm.setNote(duration,pitch);
	}
	/**
	 * Gets the absolute position in time this note starts at.
	 * @return the position in time
	 */
	public long getPosition() {
		return position;
	}
	/**
	 * Converts from an absolute position in time to a time local to this note.
	 * This gives you a time that you can then feed directly into an envelope/instrument to get the correct sample.
	 * The returned time won't mean anything if its outside the life of this note, however.
	 * @param us absolute point in time (microseconds)
	 * @return local time with 0 microseconds being the start of the note
	 */
	public long toLocalTime(long us) {
		return us-position;
	}
	/**
	 * This gets a sample from the note, accepting absolute times instead of those local to source signal.
	 * @param s source signal
	 * @param us absolute position in time (microseconds)
	 * @return the sample at that time
	 */
	public float getSample(Signal s,long us) {
		us = toLocalTime(us);
		return s.getSample(us);
	}
}