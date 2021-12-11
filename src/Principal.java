import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class Principal extends JFrame {
	
	JLabel lbTitulo;
	
	public Principal() {
		super("Smurt House");
		
		this.setSize(800, 500);
		this.setLocation(100, 50);
		this.setContentPane(crearPanelVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private Container crearPanelVentana() {
		JPanel panel = new JPanel(new BorderLayout(10,10));
		panel.add(crearPanelNorth(),BorderLayout.NORTH);
		panel.add(crearPanelCentral(),BorderLayout.CENTER);
//		panel.add(crearPanelSouth(),BorderLayout.SOUTH);
		panel.add(crearPanelSouth_v2(),BorderLayout.SOUTH);
		return panel;
	}

	private Component crearPanelNorth() {
		JToolBar toolbar = new JToolBar();
		
		JButton bHome = new JButton("home");
		bHome.setActionCommand("home");
//		bHome.addActionListener(this);
//		bHome.setUI(null); //para redondear los bordes | hacerlo "transparente"
		
		lbTitulo = new JLabel();
		lbTitulo.setFont(new Font("Arial",Font.ITALIC,18));
		lbTitulo.setText("Casa");
		
		JButton bSalir = new JButton("salir");
		bSalir.setActionCommand("exit");
//		bSalir.addActionListener(this);
		
		toolbar.add(bHome);
		toolbar.addSeparator();
		toolbar.add(lbTitulo);
		toolbar.add(Box.createGlue());
		toolbar.add(bSalir);
		return toolbar;
	}

	private Component crearPanelCentral() {
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setUI(null); //para cambiar como se veria el scroll
		
		
		
		return scroll;
	}

	private Component crearPanelSouth() {
		JToolBar toolbar = new JToolBar();
		
		JButton bHab1 = new JButton("Habitacion 1");
		bHab1.setActionCommand("home");
//		bHab1.addActionListener(this);
//		bHab1.setUI(null); //para redondear los bordes | hacerlo "transparente"
		
		lbTitulo = new JLabel();
		lbTitulo.setFont(new Font("Arial",Font.ITALIC,18));
		lbTitulo.setText("Casa");
		
		JButton bCoci = new JButton("Cocina");
		bCoci.setActionCommand("exit");
//		bCoci.addActionListener(this);
		
		toolbar.add(Box.createGlue());
		toolbar.add(bHab1);
		toolbar.add(bCoci);
		toolbar.add(Box.createGlue());
		return toolbar;
	}
	
	private Component crearPanelSouth_v2() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JButton bHab1 = new JButton("Habitacion 1");
		bHab1.setActionCommand("home");
//		bHab1.addActionListener(this);
//		bHab1.setUI(null); //para redondear los bordes | hacerlo "transparente"
		
		lbTitulo = new JLabel();
		lbTitulo.setFont(new Font("Arial",Font.ITALIC,18));
		lbTitulo.setText("Casa");
		
		JButton bCoci = new JButton("Cocina");
		bCoci.setActionCommand("exit");
//		bCoci.addActionListener(this);
		
		panel.add(bHab1);
		panel.add(bCoci);
		return panel;
	}

	public static void main(String[] args) {
		Principal programa = new Principal();
	}

}
