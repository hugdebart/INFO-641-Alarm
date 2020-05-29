package Alarme;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MoniteurWindow implements ActionListener, ListSelectionListener{

	private String message;
	protected String detail;
	private String moniteurs;
	private JFrame frame = new JFrame();
	private ArrayList<AlarmeEvent> evenList = new ArrayList<>();
	private ArrayList<Moniteur> moniteurList = new ArrayList<>();
	private JButton details = new JButton("Détails");
	private JTextField text = new JTextField();
	private JLabel text1 = new JLabel
			
			();

	private BorderLayout pos = new BorderLayout();
	private JPanel pan = new JPanel();
	
	public MoniteurWindow() throws Exception{
		frame.setTitle("Evenements reçus et non traités");
		frame.setSize(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(pos);
		text.setText(moniteurs);
		text1.setText(message);
		pan.add(details, pos.SOUTH);
		pan.add(text,pos.CENTER);
		pan.add(text1, pos.NORTH);
		frame.add(pan);
		frame.setContentPane(pan);
		frame.setVisible(true);
		
	}
	

	public void recupMoniteurText() {
		for (int i = 0; i<moniteurList.size(); i++) {
			moniteurs += moniteurList.get(i) + "\n";
		}
	}
	public void addMoniteur(Moniteur m) {
		moniteurList.add(m);
	}
	
	public void removeMoniteur(Moniteur m) {
		moniteurList.remove(m);
	}
	
	public void alarmLaunched(CapteurFeu feu, int lvlImportance, String date) {
		Iterator <Moniteur> it = this.moniteurList.iterator();
		while(it.hasNext()) {
			System.out.println("GG T nul");
			Moniteur m = it.next();
			if(m.getType() == "F") {
				feu.addListener(m);
				message = "L'alarme incendiaire s'est déclenchée, le niveau de danger est de " + lvlImportance + " à " + date;
				evenList.add(feu.genereAlarmeEvent(lvlImportance, date));
				
			}
		}
	}
	
	public void alarmLaunched(CapteurGaz gaz, int lvlImportance, String type, String date) {
		Iterator <Moniteur> it = this.moniteurList.iterator();
		while(it.hasNext()) {
			Moniteur m = it.next();
			if(m.getType() == "G") {
				gaz.addListener(m);
				message = "L'alarme de gaz s'est déclenchée, le niveau de danger est de " + lvlImportance + " à " + date + ", le gaz est du type : " + type;
				evenList.add(gaz.genererAlarmeEvent(lvlImportance, date, type));	
			}
		}
	}
	
	public void alarmLaunched(CapteurRadiation rad, int lvlImportance, int lvlRadiations, String date) {
		Iterator <Moniteur> it = this.moniteurList.iterator();
		while(it.hasNext()) {
			Moniteur m = it.next();
			if(m.getType() == "R") {
				rad.addListener(m);
				message = "L'alarme de radiations s'est déclenchée, le niveau de danger est de " + lvlImportance + " à " + date + ", le niveau de radiation est de : " + lvlRadiations;
				evenList.add(rad.genererAlarmeEvent(lvlImportance, date, lvlRadiations));                                 // generation de l'alarme et ajout à la liste des events
			}
		}
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == details) {
			System.out.println("hotzr");
			detail = "";
			for(int i = 0; i<evenList.size(); i++) {
				detail += evenList.get(i).getInformations() + "\n";
			}
			try {
				DetailWindow d1 = new DetailWindow();
			} catch (Exception e1) {
		e1.printStackTrace();
			}
			
		}
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}
}