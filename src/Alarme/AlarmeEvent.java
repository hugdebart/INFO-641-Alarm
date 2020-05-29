package Alarme;

import java.util.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;

public abstract class AlarmeEvent{
	
	private GregorianCalendar date = new GregorianCalendar();
	private int lvlImportance;
	protected int idEvent;
	protected int idCapteur;

	public AlarmeEvent(int idCapteur, int lvlImportance) {
		this.lvlImportance= lvlImportance;
		this.idCapteur=idCapteur;
//		

	}
	public abstract String getInformations();
	
	public Date getDate() {
		return date.getTime();
	}
	
	public void setdate(GregorianCalendar date) {
		this.date = date;
	}

	public int getLvlImportance() {
		return lvlImportance;
	}

	public void setLvlImportance(int lvl) {
		this.lvlImportance = lvl;
	}
	
	public int getIdCapteur() {
		return idCapteur;
	}
	
	public int getIdEvent() {
		return idEvent;
	}
}
