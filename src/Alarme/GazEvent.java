package Alarme;

public class GazEvent extends AlarmeEvent{

	protected String message;
	private String type;
	
	public GazEvent(int idCapteur, int lvlImportance, String type) {
		super(idCapteur, lvlImportance);
		this.type=type;
	}

	@Override
	public String getInformations() {
		message = "Du gaz a été détecté à " + this.getDate() + "et est de niveau d'importance " + this.getLvlImportance() + ", vient du capteur " + this.getIdCapteur() +" et est de type " + this.getType() + ".";
		return message;
	}
	
	public String getType() {
		return type;
	}

}
