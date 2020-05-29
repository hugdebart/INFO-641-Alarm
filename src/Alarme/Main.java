package Alarme;

public class Main {

	public static void main(String[] args) throws Exception {
		Moniteur feu = new Moniteur("F", 21039);
		Moniteur gaz = new Moniteur("G", 4390);
		CapteurFeu f1 = new CapteurFeu("Salle A");
		CapteurGaz g1 = new CapteurGaz("Sous-sol");
		f1.addListener(feu);
		g1.addListener(gaz);
		MoniteurWindow m1 = new MoniteurWindow();

		m1.addMoniteur(feu);
		m1.addMoniteur(gaz);
		
		f1.genereAlarmeEvent(12, "12 mai 2020 10:30");
		g1.genererAlarmeEvent(10,"23 juin 1988 12:45", "G");
		m1.recupMoniteurText();
		}
	}
