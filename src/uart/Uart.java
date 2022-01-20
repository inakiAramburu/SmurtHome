package uart;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import com.fazecast.jSerialComm.SerialPort;

import src.Preset;

public class Uart {
	Preset preset;
        SerialPort puerto;
	public Uart() {
		//this.preset=preset;

                SerialPort puertos[] = SerialPort.getCommPorts();
                System.out.println("Select a port:");
                int i = 1;
                for (SerialPort puerto : puertos) {
                        System.out.println(i++ + ". " + puerto.getSystemPortName());
                }
                Scanner s = new Scanner(System.in);
                int chosenPort = s.nextInt();
    
                // open and configure the port
                puerto = puertos[chosenPort - 1];
                if (puerto.openPort()) {
                        System.out.println("Successfully opened the port.");
                } else {
                        System.out.println("Unable to open the port.");
                        return;
                }
                puerto.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        }
      
       
        public void start(Uart uart, Preset oraingoa) {
                Thread hilo = new Thread(new Runnable() {
                        @Override
            
                        public void run() {
                            int i = 0;
                            try {
            
                                            
                                System.out.println("inicio");
                                while (true) {
                                    uart.enviar(oraingoa);
                                    // printea la clase preset
                                    System.out.println(i++ + " " + oraingoa);
                                    Thread.sleep(5);
            
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
            
                        }
            
                    });

                    hilo.start();


        }




        public void enviar(Preset preset) {
        	// determine which serial port to use
           

            Integer  datos[] = new Integer[4];
            
            byte bD[] = new byte[4];
            Scanner data = new Scanner(puerto.getInputStream());
            // enter into an infinite loop that reads from the port and updates the GUI
         
                   // String readData = new String(data.nextLine());
                 //   System.out.println(readData);
                    
                    //System.out.println("\r\nTemp: ");
                    
                    datos[0] = preset.getTemperatura();

                    //System.out.println("\r\nLuz: ");
                    datos[1] = preset.getIntensidad();

                    //System.out.println("\r\nPers: "); // NOTA modo automatico
                    datos[2] = preset.getPersiana();

                   // System.out.println("\r\n automatico: ");
                    datos[3] = preset.getAutomatico();
                    // Convert Integer number to byte value
                    for (int i = 0; i < datos.length; i++)
                            bD[i] = datos[i].byteValue();

                    puerto.writeBytes(bD, datos.length);
            

		}

      
    

}

