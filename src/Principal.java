import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.ParallelGroup;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class Principal extends JFrame implements ActionListener {
	final static int MAX_PANELES = 5;
	final static String COM_CHANGE = "cambiar";
	JPanel panelVisual;
	
	// Variables declaration - do not modify                     
	 	private javax.swing.JPanel panelHome;
	    private javax.swing.JButton automaticoButton;
	    private javax.swing.JButton bajarPButton;
	    private javax.swing.JButton bajarTButton;
	    private javax.swing.JFormattedTextField jFormattedTextField1;
	    public javax.swing.JButton luzButton;
	    private javax.swing.JButton menuButon;
	    private javax.swing.JButton microfonoButton;
	    private javax.swing.JPanel panelPersiana;
	    private javax.swing.JPanel panelRojo;
	    private javax.swing.JPanel panelTemperatura;
	    private javax.swing.JButton pararPButton;
	    private javax.swing.JButton subirPButton;
	    private javax.swing.JFormattedTextField titulo;
	    private javax.swing.JButton upButton;
    // End of variables declaration     
    
    int temperatura=20;
    int intensidad=0;
    int persiana=0;
    int microfono=0;
    int automatico=0;
    
    List<ImageIcon> luz;
    ImageIcon bombilla0,bombilla1,bombilla2,bombilla3;
    ImageIcon home;
	
	
	
	public Principal() {
		super("Smurt House");
		
		
		luz=new ArrayList<ImageIcon>();
        
        bombilla0 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla0.png");
        bombilla1 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla1.png");
        bombilla2 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla2.png");
        bombilla3 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla3.png");
        luz.add(bombilla0);
        luz.add(bombilla1);
        luz.add(bombilla2);
        luz.add(bombilla3);
		
		
		
		panelVisual = new JPanel(new CardLayout());
		this.setSize(1600, 800);
		this.setLocation(100, 50);
		this.setContentPane(panelVisual);
		cambiarPanel(crearPanelPrincipal());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	private Container cambiarPanel(JPanel panelActual) {
		panelVisual.removeAll();
		panelVisual.add(panelActual);
		panelVisual.repaint();
		panelVisual.revalidate();
		return panelVisual;
	}
	
	
	
	private JPanel crearPanelPrincipal() {

        panelHome = new javax.swing.JPanel();
        panelTemperatura = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        bajarTButton = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        luzButton = new javax.swing.JButton();
        panelPersiana = new javax.swing.JPanel();
        subirPButton = new javax.swing.JButton();
        pararPButton = new javax.swing.JButton();
        bajarPButton = new javax.swing.JButton();
        menuButon = new javax.swing.JButton();
        titulo = new javax.swing.JFormattedTextField();
        automaticoButton = new javax.swing.JButton();
        panelRojo = new javax.swing.JPanel();
        microfonoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTemperatura.setPreferredSize(new java.awt.Dimension(400, 260));

        upButton.setBackground(new java.awt.Color(255, 51, 51));
        upButton.setFont(new java.awt.Font("Product San", 0, 60));
        upButton.setText("+");
        upButton.setToolTipText("");
        upButton.setBorder(null);
        upButton.setBorderPainted(false);
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        bajarTButton.setBackground(new java.awt.Color(0, 204, 255));
        bajarTButton.setFont(new java.awt.Font("Product San", 0, 60));
        bajarTButton.setText("-");
        bajarTButton.setBorder(null);
        bajarTButton.setBorderPainted(false);
        bajarTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajarTButtonActionPerformed(evt);
            }
        });

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setBorder(null);
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setText(temperatura+"");
        jFormattedTextField1.setFont(new java.awt.Font("Product San", 0, 60));
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTemperaturaLayout = new javax.swing.GroupLayout(panelTemperatura);
        panelTemperatura.setLayout(panelTemperaturaLayout);
        panelTemperaturaLayout.setHorizontalGroup(
            panelTemperaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(bajarTButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTemperaturaLayout.setVerticalGroup(
            panelTemperaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTemperaturaLayout.createSequentialGroup()
                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bajarTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        luzButton.setBackground(new java.awt.Color(51, 153, 255));
        luzButton.setIcon(new ImageIcon(luz.get(intensidad).getImage()));
        luzButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luzButtonActionPerformed(evt);
            }
        });

        panelPersiana.setPreferredSize(new java.awt.Dimension(400, 260));

        subirPButton.setFont(new java.awt.Font("Product San", 0, 60));
        subirPButton.setText("Subir");
        subirPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirPButtonActionPerformed(evt);
            }
        });

        pararPButton.setFont(new java.awt.Font("Product San", 0, 60));
        pararPButton.setText("||");
        pararPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararPButtonActionPerformed(evt);
            }
        });

        bajarPButton.setFont(new java.awt.Font("Product San", 0, 60));
        bajarPButton.setText("Bajar");
        bajarPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajarPButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPersianaLayout = new javax.swing.GroupLayout(panelPersiana);
        panelPersiana.setLayout(panelPersianaLayout);
        panelPersianaLayout.setHorizontalGroup(
            panelPersianaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pararPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bajarPButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(subirPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPersianaLayout.setVerticalGroup(
            panelPersianaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersianaLayout.createSequentialGroup()
                .addComponent(subirPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pararPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bajarPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuButon.setBackground(new java.awt.Color(51, 255, 255));
        menuButon.setFont(new java.awt.Font("Product San", 0, 20));
        home =new ImageIcon("iconos/PanelPrincipal/casa.png");
        menuButon.setIcon(new ImageIcon(home.getImage()));
        menuButon.setBorder(null);
        menuButon.setBorderPainted(false);
        menuButon.setActionCommand("menu");
        menuButon.addActionListener(this);

        titulo.setEditable(false);
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setText("UNO mas UNO es ILEGAL");
        titulo.setFont(new java.awt.Font("Product San", 0, 60));

        automaticoButton.setFont(new java.awt.Font("Product San", 0, 60));
        automaticoButton.setText("Automatico");
        automaticoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automaticoButtonActionPerformed(evt);
            }
        });

        panelRojo.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
        panelRojo.setLayout(panelRojoLayout);
        panelRojoLayout.setHorizontalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        panelRojoLayout.setVerticalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        microfonoButton.setFont(new java.awt.Font("Product San", 0, 60));
        microfonoButton.setText("Microfono");
        microfonoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                microfonoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(menuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(panelTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(luzButton, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(panelPersiana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(automaticoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400)
                        .addComponent(microfonoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addComponent(panelPersiana, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelHomeLayout.createSequentialGroup()
                                .addComponent(luzButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(100, 100, 100)
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(automaticoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(microfonoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
		return panelHome;
	}
	
	
  
	

	private JPanel crearPanelMenu() {

		  JButton graficosButton1;
		  JButton homeButon;
		  JPanel panelMenu;
		  JPanel panelRojo;
		  JButton presetButton;
		  JFormattedTextField titulo;
		
		panelMenu = new javax.swing.JPanel();
        homeButon = new javax.swing.JButton();
        titulo = new javax.swing.JFormattedTextField();
        panelRojo = new javax.swing.JPanel();
        presetButton = new javax.swing.JButton();
        graficosButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeButon.setBackground(new java.awt.Color(51, 255, 255));
        homeButon.setFont(new java.awt.Font("Product San", 0, 20));
        home =new ImageIcon("iconos/PanelPrincipal/casa.png");
        homeButon.setIcon(new ImageIcon(home.getImage()));
        homeButon.setBorder(null);
        homeButon.setBorderPainted(false);
        homeButon.setActionCommand("home");
        homeButon.addActionListener(this);
       

        titulo.setEditable(false);
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setText("Menu");
        titulo.setFont(new java.awt.Font("Product San", 0, 60));
        
       

        panelRojo.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
        panelRojo.setLayout(panelRojoLayout);
        panelRojoLayout.setHorizontalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        panelRojoLayout.setVerticalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        presetButton.setText("Preset");
        
        presetButton.setActionCommand("preset");
        presetButton.addActionListener(this);

        graficosButton1.setText("Graficos");
        graficosButton1.setActionCommand("graficos");
        graficosButton1.addActionListener(this);


        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(presetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(graficosButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(presetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(graficosButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
		
		
		
		return panelMenu;
	}
	
	private JPanel crearPanelPreset() throws ClassNotFoundException {
        

         JButton anadirButton;
         JButton atrasButton;
         JButton borrarButton;
         JButton homeButon;
         JButton jButton1;
         JButton jButton2;
         JButton jButton3;
         JButton jButton4;
         JPanel jPanel2;
         javax.swing.JScrollPane jScrollPane2;
         JPanel panelPreset;
         JPanel panelRojo;
         JFormattedTextField titulo;

         List<JButton> botones;
            int cantidadDepreset=0;

            cantidadDepreset=cantidadDepreset();
            botones=new ArrayList<JButton>();


          


            panelPreset = new javax.swing.JPanel();
            homeButon = new javax.swing.JButton();
            titulo = new javax.swing.JFormattedTextField();
            panelRojo = new javax.swing.JPanel();
            jScrollPane2 = new javax.swing.JScrollPane();
            jPanel2 = new javax.swing.JPanel();
            anadirButton = new javax.swing.JButton();
            borrarButton = new javax.swing.JButton();
            atrasButton = new javax.swing.JButton();
    
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
            panelPreset.setBackground(new java.awt.Color(255, 255, 255));
    
            homeButon.setBackground(new java.awt.Color(51, 255, 255));
            homeButon.setFont(new java.awt.Font("Product San", 0, 20));
            home =new ImageIcon("iconos/PanelPrincipal/casa.png");
            homeButon.setIcon(new ImageIcon(home.getImage()));
            homeButon.setBorder(null);
            homeButon.setBorderPainted(false);
            homeButon.setActionCommand("home");
            homeButon.addActionListener(this);

           //añadir botones en el panel2

        for(int i=0;i<50;i++){
            JButton botone =new JButton("Boton"+i);
            botone.setFont(new Font("Product San", 0, 20));

            botone.setActionCommand("home");
            botone.addActionListener(this);
            jPanel2.add(botone);
            botones.add(botone);
        
        }


           

          

    
            titulo.setEditable(false);
            titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            titulo.setText("Preset");
            titulo.setFont(new java.awt.Font("Product San", 0, 60));
            JButton boton =new JButton("Boton");


           

          
    
            panelRojo.setBackground(new java.awt.Color(255, 0, 0));
    
            javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
            panelRojo.setLayout(panelRojoLayout);
            panelRojoLayout.setHorizontalGroup(
                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 149, Short.MAX_VALUE)
            );
            panelRojoLayout.setVerticalGroup(
                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 150, Short.MAX_VALUE)
            );
    
            jScrollPane2.setBorder(null);
            jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    
            jPanel2.setBackground(new java.awt.Color(255, 255, 255));
            jPanel2.setLayout(new java.awt.GridLayout(1, 3));
            jScrollPane2.setViewportView(jPanel2);
    
            anadirButton.setText("+");
            anadirButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    anadirButtonActionPerformed(evt);
                }
            });
    
            borrarButton.setText("-");
    
            atrasButton.setText("Atras");
    
            javax.swing.GroupLayout panelPresetLayout = new javax.swing.GroupLayout(panelPreset);
            panelPreset.setLayout(panelPresetLayout);
            panelPresetLayout.setHorizontalGroup(
                panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPresetLayout.createSequentialGroup()
                    .addComponent(anadirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(borrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(atrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(panelPresetLayout.createSequentialGroup()
                    .addGroup(panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPresetLayout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPresetLayout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panelPresetLayout.setVerticalGroup(
                panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPresetLayout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(100, 100, 100)
                    .addGroup(panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(anadirButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(borrarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atrasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
    
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelPreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(panelPreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0))
            );
    
            pack();
	    
	    
		
		return panelPreset;
	}
	
	
	
    private int cantidadDepreset() throws ClassNotFoundException {
        int cantidad=0;
        
        FileInputStream ficheroEntrada=null;
        List<Preset> listaPreset = new ArrayList<Preset>();
        try {
            ficheroEntrada=new FileInputStream("datos.txt");
            try (ObjectInputStream tuberia = new ObjectInputStream(ficheroEntrada)) {
                listaPreset=(List<Preset>)tuberia.readObject();
            }
            for (Preset p:listaPreset){
                p.mostrarDatos();
            }
           
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){

            ex.printStackTrace();
        }
        cantidad   = listaPreset.size();


        return cantidad;
    }

    private JPanel crearPanelGraficos() {
    	 	JButton homeButon;
    	    JPanel panelGraficos;
    	    JPanel panelRojo;
    	    JFormattedTextField titulo;
    	    panelGraficos = new javax.swing.JPanel();
            homeButon = new javax.swing.JButton();
            titulo = new javax.swing.JFormattedTextField();
            panelRojo = new javax.swing.JPanel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            homeButon.setBackground(new java.awt.Color(51, 255, 255));
            homeButon.setFont(new java.awt.Font("Product San", 0, 20));
            home =new ImageIcon("iconos/PanelPrincipal/casa.png");
            
            homeButon.setIcon(new ImageIcon(home.getImage()));
            homeButon.setBorder(null);
            homeButon.setBorderPainted(false);
            
            homeButon.setActionCommand("home");
            homeButon.addActionListener(this);
            
            

            titulo.setEditable(false);
            titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            titulo.setText("Graficos");
            titulo.setFont(new java.awt.Font("Product San", 0, 60));
          

            panelRojo.setBackground(new java.awt.Color(255, 0, 0));

            javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
            panelRojo.setLayout(panelRojoLayout);
            panelRojoLayout.setHorizontalGroup(
                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 149, Short.MAX_VALUE)
            );
            panelRojoLayout.setVerticalGroup(
                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 150, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout panelGraficosLayout = new javax.swing.GroupLayout(panelGraficos);
            panelGraficos.setLayout(panelGraficosLayout);
            panelGraficosLayout.setHorizontalGroup(
                panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGraficosLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(90, 90, 90))
            );
            panelGraficosLayout.setVerticalGroup(
                panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficosLayout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(660, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

    	    
    	    
    	    
    	
        return panelGraficos;
    }
	
	
	
	
	private void jFormattedTextField1ActionPerformed(ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void bajarTButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
        if(temperatura>17){
            temperatura--;
            jFormattedTextField1.setText(temperatura+"");
        }
        System.out.println(temperatura);
        
    }                                            

    private void upButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
         // TODO add your handling code here:
        if(temperatura<30){
            temperatura++;
            jFormattedTextField1.setText(temperatura+"");
        }
        System.out.println(temperatura);
        
        
    }                                        

    private void luzButtonActionPerformed(ActionEvent evt) {                                          
        // TODO add your handling code here:
         // TODO add your handling code here:
         
        
     
//luzButton.setIcon(new ImageIcon(azul.getImage()));
        if (intensidad==0){
            intensidad=1;
        } else if (intensidad!=0){
            if (intensidad==3){
                intensidad=0;
            }else{
            intensidad++;
            }
        }else if(false /* esterar dos segundos*/){
         intensidad=0;
        }
        System.out.println("Intensidad: "+intensidad);
        switch(intensidad){
    case 0:
      //  luzButton.setBackground(new java.awt.Color(204, 204, 204));
        break;
    case 1:
     //   luzButton.setBackground(new java.awt.Color(153, 255, 153));
        break;
    case 2:
      //  luzButton.setBackground(new java.awt.Color(102, 255, 102));
        break;
    case 3:
        //luzButton.setBackground(new java.awt.Color(0, 255, 0));
        break;
      // luzButton.setIcon(new ImageIcon(luz.get(intensidad).getImage()));

        
         } 
         luzButton.setIcon( new ImageIcon(luz.get(intensidad).getImage()));
    }                                         

    private void bajarPButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
          persiana=2;
        System.out.println(persiana);
    }                                            

    private void subirPButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
        persiana=1;
        System.out.println(persiana);
        
        
        
    }                                            

    private void pararPButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
          persiana=0;
        System.out.println(persiana);
    }                                            

    private void microfonoButtonActionPerformed(ActionEvent evt) {                                                
        
        
      if (microfono==0){
    	  microfono=1;
      }else{
    	  microfono=0;
      }
      System.out.println("microfono: "+microfono);
       
    	
    	
    	
    }                                               

    private void automaticoButtonActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
    	
    	 if (automatico==0) {
    		 automatico=1;
         }else {
        	 automatico=0;
         }
         
         System.out.println("automatico: "+automatico);
    }                                           
                                     
  ///preset///

  private void anadirButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    // TODO add your handling code here:
    System.out.println("añadiir preset");
}                                            

private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    // TODO add your handling code here:
    System.out.println("borrar preset");
}                                            

private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
    // TODO add your handling code here:
    System.out.println("atras");
}                                           
////

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("menu")) {
			cambiarPanel(crearPanelMenu());
		}
		if(comando.equals("home")) {
			cambiarPanel(crearPanelPrincipal());
		}
		if(comando.equals("preset")) {
			try {
                cambiarPanel(crearPanelPreset());
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
        if(comando.equals("graficos")) {
			cambiarPanel(crearPanelGraficos());
		}
		if(comando.equals("users")) {
			cambiarPanel(crearPanelPrincipal());
		}
	}
	
	
void crearDatosDePrueba(){
    List<Preset> listaPreset = new ArrayList<Preset>();

    Preset preset =new Preset("prueba", 20, 0, 1);
    Preset preset2 =new Preset("prueba2", 25, 0, 2);
    listaPreset.add(preset);
    listaPreset.add(preset2);

    FileOutputStream fichero=null;
    preset.mostrarDatos();

    try {
        fichero=new FileOutputStream("datos.txt");
        ObjectOutputStream tuberia =new ObjectOutputStream(fichero);
        tuberia.writeObject(listaPreset);


    }catch (FileNotFoundException ex){
        ex.printStackTrace();
    }catch (IOException ex){

        ex.printStackTrace();
    }finally{
        try{
            fichero.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    System.out.println("-------------------------------------------------------");
}
	

    public static void main(String[] args) throws ClassNotFoundException {
       // Preset porDefecrto = new Preset("UNO MAS UNO ES ILEGALISIMO", 20, 0, 0);
		
        Principal programa = new Principal();
        
       

	}

}
