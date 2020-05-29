package Alarme;

import javax.swing.event.EventListenerList;

public abstract class Capteur {

	protected int id = 0;
	private String loc;
	private String type;
	protected final EventListenerList listeners = new EventListenerList();
	
	public Capteur(String localisation) {
		this.loc=localisation;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getLocalisation() {
		return loc;
	}
}
