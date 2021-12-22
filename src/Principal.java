import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JFrame implements ActionListener {
	final static int MAX_PANELES = 5;
	final static String COM_CHANGE = "cambiar";
	JPanel panelVisual;
	
	public Principal() {
		super("Smurt House");
		panelVisual = new JPanel(new CardLayout());
		this.setSize(800, 500);
		this.setLocation(100, 50);
		this.setContentPane(panelVisual);
		cambiarPanel(crearPanelPrincipal());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private Container cambiarPanel(JPanel panelActual) {
		panelVisual.removeAll();
		panelVisual.add(panelActual);
		panelVisual.repaint();
		panelVisual.revalidate();
		return panelVisual;
	}
	
	private JPanel crearPanelPrincipal() {
		JPanel principal = new JPanel(new BorderLayout());
		principal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JLabel label = new JLabel("Nombre de Usuario");
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		JButton bHome = new JButton("Home");
		bHome.setActionCommand("home");
		bHome.addActionListener(this);
		
		JPanel panelNorte = new JPanel();
		panelNorte.add(bHome);
		panelNorte.add(label);
		principal.add(panelNorte,BorderLayout.NORTH);
		principal.add(bHome,BorderLayout.CENTER);
		return principal;
	}
	
	private JPanel crearPanelElaborado() {
		JPanel panelNormal = new JPanel(new BorderLayout());
		
		JLabel label = new JLabel("ey");
		label.setFont(new Font("Arial",Font.BOLD,90));
		label.setBackground(Color.green);
		label.setForeground(Color.blue);
		label.setOpaque(true);
		
		panelNormal.add(label,BorderLayout.NORTH);
		panelNormal.add(crearPanelBotones(),BorderLayout.CENTER);
		return panelNormal;
	}

	private Component crearPanelBotones() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		JButton bUsers = new JButton("Usuarios");
		bUsers.setActionCommand("users");
		bUsers.addActionListener(this);
		
		JButton bGraph = new JButton("Graficos");
		bGraph.setActionCommand("graficos");
		bGraph.addActionListener(this);
		
		panel.add(bUsers);
		panel.add(bGraph);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("home")) {
			cambiarPanel(crearPanelElaborado());
		}
		if(comando.equals("users")) {
			cambiarPanel(crearPanelPrincipal());
		}
	}
	
	public static void main(String[] args) {
		Principal programa = new Principal();
	}

}
