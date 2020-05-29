package Alarme;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DetailWindow extends MoniteurWindow {

	
	private JFrame frame = new JFrame();
	private JPanel pan = new JPanel();
	private JTextField text = new JTextField();
	private BorderLayout pos = new BorderLayout();
	
	public DetailWindow() throws Exception{
		
		frame.setTitle("Détails de l'alarmeé");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text.setText(detail);
		pan.add(text, pos.CENTER);
		
		frame.setContentPane(pan);
		frame.setVisible(true);
		 
		
	}
}
