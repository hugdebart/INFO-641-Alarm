package Alarme;

public class FireEvent extends AlarmeEvent{
	
	protected String message;
	
	public FireEvent(int idCapteur, int lvlImportance) {
		super(idCapteur, lvlImportance);
	}

	@Override
	public String getInformations() {
		message = "C'est un incendie qui s'est d�clar� � " + this.getDate() + "et est de niveau d'importance " + this.getLvlImportance() + " et vient du capteur " + this.getIdCapteur() +".";
		
		return message;
	}
}