package paneles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import src.Controlador;
import src.Preset;

public class PanelCrearPreset extends JFrame {

    private javax.swing.JButton bajarPButton;
    private javax.swing.JButton bajarTButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JPanel creadorPreset;
    private javax.swing.JButton guardarButton;
    private javax.swing.JFormattedTextField temperaturaTXT;
    public javax.swing.JButton luzButton;
    private javax.swing.JButton menuButon;
    private javax.swing.JPanel panelPersiana;
    private javax.swing.JPanel panelRojo;
    private javax.swing.JPanel panelTemperatura;
    private javax.swing.JButton pararPButton;
    private javax.swing.JButton subirPButton;
    private javax.swing.JFormattedTextField titulo;
    private javax.swing.JButton upButton;
    Controlador controlador;

    String nombre;
    int temperatura=20;
    int intensidad=0;
    int persiana=0;
    int microfono=0;
    int automatico=0;

    List<ImageIcon> luz;
    ImageIcon bombilla0,bombilla1,bombilla2,bombilla3;
    ImageIcon home;


    public PanelCrearPreset(Controlador controlador){
        this.controlador=controlador;
		luz=new ArrayList<ImageIcon>();
        
        bombilla0 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla0.png");
        bombilla1 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla1.png");
        bombilla2 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla2.png");
        bombilla3 =new ImageIcon("iconos/PanelPrincipal/luz/bombilla3.png");
        luz.add(bombilla0);
        luz.add(bombilla1);
        luz.add(bombilla2);
        luz.add(bombilla3);
		
		//horaingoa=preset;
        this.nombre="jeje";
        this.temperatura=20;    
        this.intensidad=0;
        this.persiana=0;
        this.microfono=1;
        this.automatico=0;
        

        
       


        creadorPreset = new javax.swing.JPanel();
        panelTemperatura = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        bajarTButton = new javax.swing.JButton();
        temperaturaTXT = new javax.swing.JFormattedTextField();
        luzButton = new javax.swing.JButton();
        panelPersiana = new javax.swing.JPanel();
        subirPButton = new javax.swing.JButton();
        pararPButton = new javax.swing.JButton();
        bajarPButton = new javax.swing.JButton();
        menuButon = new javax.swing.JButton();
        titulo = new javax.swing.JFormattedTextField();
        guardarButton = new javax.swing.JButton();
        panelRojo = new javax.swing.JPanel();
        cancelarButton = new javax.swing.JButton();

       

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

        temperaturaTXT.setEditable(false);
        temperaturaTXT.setBorder(null);
        temperaturaTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        temperaturaTXT.setText(temperatura+"");
        temperaturaTXT.setFont(new java.awt.Font("Product San", 0, 60));
        

        javax.swing.GroupLayout panelTemperaturaLayout = new javax.swing.GroupLayout(panelTemperatura);
        panelTemperatura.setLayout(panelTemperaturaLayout);
        panelTemperaturaLayout.setHorizontalGroup(
            panelTemperaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(temperaturaTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(bajarTButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTemperaturaLayout.setVerticalGroup(
            panelTemperaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTemperaturaLayout.createSequentialGroup()
                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(temperaturaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
       
        menuButon.setActionCommand("home");
		menuButon.addActionListener(controlador);

        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setText("Nombre");
        titulo.setFont(new java.awt.Font("Product San", 0, 60));
        

        guardarButton.setFont(new java.awt.Font("Product San", 0, 60));
        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        guardarButton.setActionCommand("home");
		guardarButton.addActionListener(controlador);

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

        cancelarButton.setFont(new java.awt.Font("Product San", 0, 60));
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        cancelarButton.setActionCommand("preset");
		cancelarButton.addActionListener(controlador);

        
        javax.swing.GroupLayout creadorPresetLayout = new javax.swing.GroupLayout(creadorPreset);
        creadorPreset.setLayout(creadorPresetLayout);
        creadorPresetLayout.setHorizontalGroup(
            creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creadorPresetLayout.createSequentialGroup()
                .addGroup(creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creadorPresetLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(menuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(creadorPresetLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(panelTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(luzButton, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(panelPersiana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(creadorPresetLayout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        creadorPresetLayout.setVerticalGroup(
            creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creadorPresetLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creadorPresetLayout.createSequentialGroup()
                        .addComponent(panelPersiana, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(creadorPresetLayout.createSequentialGroup()
                        .addGroup(creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(creadorPresetLayout.createSequentialGroup()
                                .addComponent(luzButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(100, 100, 100)
                        .addGroup(creadorPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(creadorPreset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(creadorPreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();



    }


    public JPanel getPanel(){
		return creadorPreset;
	}



    private void bajarTButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        if(temperatura>17){
            temperatura--;
            temperaturaTXT.setText(temperatura+"");
        }
        System.out.println(temperatura);
        
    }                                            

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         // TODO add your handling code here:
        if(temperatura<30){
            temperatura++;
            temperaturaTXT.setText(temperatura+"");
        }
        System.out.println(temperatura);
        
        
    }                                        

    private void luzButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
        }else {
         intensidad=0;
        }
        System.out.println("Intensidad: "+intensidad);
 
         luzButton.setIcon( new ImageIcon(luz.get(intensidad).getImage()));
    }                                         

    private void bajarPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
          persiana=2;
        System.out.println(persiana);
    }                                            

    private void subirPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        persiana=1;
        System.out.println(persiana);
        
        
        
    }                                            

    private void pararPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
          persiana=0;
        System.out.println(persiana);
    }                                            

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        System.out.println("cancelar");
        
    }                                              

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        List<Preset> listaPreset=null;
        try {
            listaPreset = presetGuardados();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < listaPreset.size(); i++) {
            if (listaPreset.get(i).getNombre().equals(titulo.getText())){
                JOptionPane.showMessageDialog(null, "Ya existe un preset con ese nombre");
                return;
            }
        }





       
        Preset preset = new Preset(titulo.getText(),temperatura,intensidad,persiana,microfono,automatico);
        
     
      

        listaPreset.add(preset);

       

       


        anadirDatos(listaPreset);

        System.out.println("Guardar");
        preset.mostrarDatos();
      
      



    }


    private List<Preset> presetGuardados() throws ClassNotFoundException {

		FileInputStream ficheroEntrada = null;
		List<Preset> listaPreset = new ArrayList<Preset>();
		try {
			ficheroEntrada = new FileInputStream("datos.txt");
			try (ObjectInputStream tuberia = new ObjectInputStream(ficheroEntrada)) {
				listaPreset = (List<Preset>) tuberia.readObject();
			}
			for (Preset p : listaPreset) {
				p.mostrarDatos();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {

			ex.printStackTrace();
		}

		return listaPreset;
	}


    private void anadirDatos(List<Preset> listaPreset) {

        FileOutputStream fichero = null;
        

        try {
            fichero = new FileOutputStream("datos.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(listaPreset);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }  

   




    
}
