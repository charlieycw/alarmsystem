package ca.ubc.cpsc210.alarm.model;

/**
 * Represents an alarm.
 */
public class Alarm extends Observable {
	private boolean isSounding;
	
	/**
	 * Constructor creates a silent alarm.
	 */
	public Alarm() {
		isSounding = false; // changed
	}
	
	/**
	 * Turns the alarm on.
	 */
	public void sound() {
		isSounding = true; // changed 
		notifyObservers();
		EventLog.getInstance().logEvent(new Event("Alarm triggered."));
	}
	
	/**
	 * Turns the alarm off.
	 */
	public void silence() {
		isSounding = false;
		notifyObservers();
		
		else {
			EventLog.getInstance().logEvent(new Event("Alarm silenced."));
		}
	}
	
	/**
	 * Determines if alarm is sounding.
	 * @return  true if sounding, false otherwise
	 */
	public boolean isSounding() {
		return isSounding; //change
	}
	
	@Override
	public void notifyObservers() {
		for (Observer next : observers) {
			next.update(isSounding);
		}
	}
}
