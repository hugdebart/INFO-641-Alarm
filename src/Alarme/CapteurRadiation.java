package Alarme;

public class CapteurRadiation extends Capteur {

	
	public CapteurRadiation(String loc) {
		super(loc);
	}
	
	public RadiationEvent genererAlarmeEvent(int lvlImportance,String date, int lvlRadiation) {

	RadiationEvent r1 = new RadiationEvent(id, lvlImportance, lvlRadiation);
	
	for(RadiationListener radiationListener : this.getRadiationListeners()) {
		radiationListener.alarmLaunched(r1);
	}
	
	return r1;
}

	public RadiationListener[] getRadiationListeners(){
		return this.listeners.getListeners(RadiationListener.class);
	}
	
	public void addListener(FireListener fl) {
		this.listeners.add(FireListener.class, fl);
		}

	

	}
