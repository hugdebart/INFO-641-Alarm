package Alarme;

public class CapteurGaz extends Capteur {
	
	
	public CapteurGaz(String loc) {
		super(loc);
	}
	
	public GazEvent genererAlarmeEvent(int lvlImportance, String date, String typeGaz) {
		GazEvent g1 = new GazEvent(id, lvlImportance, date);
		
		for(GazListener gazListener : this.getGazListeners()) {
			gazListener.alarmLaunched(g1);
		}
		return g1;
	}

	public GazListener[] getGazListeners() {
		return this.listeners.getListeners(GazListener.class);
	}

	public void addListener(GazListener fl) {
	this.listeners.add(GazListener.class, fl);
	}

}
