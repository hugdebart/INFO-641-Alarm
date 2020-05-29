package Alarme;

public class RadiationEvent extends AlarmeEvent{
	protected String message;
	private int lvlRad;
	public RadiationEvent(int idCapteur, int lvlImportance, int lvlRad) {
		super(idCapteur, lvlImportance);
		this.lvlRad=lvlRad;
	}

	@Override
	public String getInformations() {
		message = "Des radiations ont été déclaré à " + this.getDate() + "et est de niveau d'importance " + this.getLvlImportance() + " et vient du capteur " + this.getIdCapteur() +" et le niveau de radiation est de " + lvlRad + ".";
		return message;
	}
	
	public int getLvlRad(){
		return lvlRad;
	}

}
