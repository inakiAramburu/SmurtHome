package paneles;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Controlador;

public class PanelGraficos extends JFrame {

    JButton homeButon;
    JPanel panelGraficos;
    JPanel panelRojo;
    JFormattedTextField titulo;
    Controlador controlador;
    ImageIcon home,icono;
    JLabel iconoLabel;
       

    public PanelGraficos(Controlador controlador) {
        this.controlador = controlador;
        

        panelGraficos = new javax.swing.JPanel();
        homeButon = new javax.swing.JButton();
        titulo = new javax.swing.JFormattedTextField();
        panelRojo = new javax.swing.JPanel();
        iconoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeButon.setBackground(new java.awt.Color(36, 36, 36));
        homeButon.setFont(new java.awt.Font("Product San", 0, 20));
        home = new ImageIcon("iconos/PanelPrincipal/casa.png");
        icono =new ImageIcon("iconos/icono.png");
        homeButon.setIcon(new ImageIcon(home.getImage()));
        homeButon.setBorder(null);
        homeButon.setBorderPainted(false);

        homeButon.setActionCommand("home");
        homeButon.addActionListener(controlador);

        titulo.setEditable(false);
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setText("Graficos");
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setBackground(new java.awt.Color(58, 58, 58));

        titulo.setFont(new java.awt.Font("Product San", 0, 60));

        panelRojo.setBackground(new java.awt.Color(36, 36, 36));
       
        ////////////////////////////////////////

        panelRojo.setBackground(new java.awt.Color(36, 36, 36));
        panelRojo.setPreferredSize(new java.awt.Dimension(150, 150));

        iconoLabel.setIcon(icono);

        javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
        panelRojo.setLayout(panelRojoLayout);
        panelRojoLayout.setHorizontalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRojoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(iconoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRojoLayout.setVerticalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRojoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(iconoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
       
        ////////////////////////////////////////
        
        
        javax.swing.GroupLayout panelGraficosLayout = new javax.swing.GroupLayout(panelGraficos);
        panelGraficos.setBackground(new java.awt.Color(36, 36, 36));
        panelGraficos.setLayout(panelGraficosLayout);
        panelGraficosLayout
                .setHorizontalGroup(
                        panelGraficosLayout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelGraficosLayout.createSequentialGroup().addGap(90, 90, 90)
                                        .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 999,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)));
        panelGraficosLayout.setVerticalGroup(panelGraficosLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficosLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(660, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGraficos, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelGraficos,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

    }


    public JPanel getPanel(){
		return panelGraficos;
	}
}
