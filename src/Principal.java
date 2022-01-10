import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import com.fazecast.jSerialComm.SerialPort;

public class Principal {
	public Principal() {
		// create a window with a slider
        JFrame window = new JFrame();
        JLabel label = new JLabel();
        label.setSize(200, 100);
        window.add(label);
        window.pack();
        window.setVisible(true);
       
        // determine which serial port to use
        SerialPort puertos[] = SerialPort.getCommPorts();
        System.out.println("Select a port:");
        int i = 1;
        for(SerialPort puerto : puertos) {
                System.out.println(i++ + ". " + puerto.getSystemPortName());
        }
        Scanner s = new Scanner(System.in);
        int chosenPort = s.nextInt();

        // open and configure the port
        SerialPort puerto = puertos[chosenPort - 1];
        if(puerto.openPort()) {
                System.out.println("Successfully opened the port.");
        } else {
                System.out.println("Unable to open the port.");
                return;
        }
        puerto.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
       
        // enter into an infinite loop that reads from the port and updates the GUI
        Scanner data = new Scanner(puerto.getInputStream());
        while(data.hasNextLine()) {
        	System.out.println(data.nextLine());
//                int number = 0;
//                try{number = Integer.parseInt(data.nextLine());}catch(Exception e){}
//                slider.setValue(number);
        }
	}
	
//	@Override
//	public int getListeningEvents() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void serialEvent(SerialPortEvent arg0) {
//		// TODO Auto-generated method stub
//
//	}

	public static void main(String[] args) {
		Principal programa = new Principal();

	}

}
