package Alarme;

public class CapteurFeu extends Capteur{
	
	
	
	public CapteurFeu(String loc) {
		super(loc);
	}
	
	public FireEvent genereAlarmeEvent(int lvlImportance, String date) {
		FireEvent fire = new FireEvent(id, lvlImportance);
	
		for(FireListener fireListener : this.getFireListeners()) {
			fireListener.alarmLaunched(fire);

		}
		return fire;
	}
	

private FireListener[] getFireListeners() {
	return this.listeners.getListeners(FireListener.class);
	}

public void addListener(FireListener fl) {
	this.listeners.add(FireListener.class, fl);
	}
}