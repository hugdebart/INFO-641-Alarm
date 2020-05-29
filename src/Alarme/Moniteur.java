package Alarme;

public class Moniteur implements FireListener, GazListener, RadiationListener{

	private String type;
	private int id;
	
	public Moniteur(String type, int id) throws Exception {
		this.type=type;
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public void alarmLaunched(FireEvent feu) {
		System.out.println("L'alarme incendiaire s'est d�clench�e, le niveau de danger est de " + feu.getLvlImportance() + " � " + feu.getDate());
	}
	
	@Override
	public void alarmLaunched(GazEvent gaz) {
		System.out.println("L'alarme de gaz s'est d�clench�e, le niveau de danger est de " + gaz.getLvlImportance() + " � " + gaz.getDate() + ", le gaz est du type : " + gaz.getType());
	}

	@Override
	public void alarmLaunched(RadiationEvent rad) {
		System.out.println("L'alarme de radiations s'est d�clench�e, le niveau de danger est de " + rad.getLvlImportance() + " � " + rad.getDate() + ", le niveau de radiation est de : " + rad.getLvlRad());
	}
	
}
