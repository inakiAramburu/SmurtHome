import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.fazecast.jSerialComm.*;


public class Principal {
	
    public static void main(String[] args) {
    	JFrame ventana = new JFrame();
    	JLabel label = new JLabel();
    	ventana.add(label);
    	ventana.pack();
    	ventana.setVisible(true);
       
        // determine which serial port to use
        List<SerialPort> puertos = Arrays.stream(SerialPort.getCommPorts()).collect(Collectors.toList());
        System.out.println("Select a port:");
        int i = 1;
        for(SerialPort port : puertos) {
                System.out.println(i++ + ". " + port.getSystemPortName());
        }
        Scanner teclado = new Scanner(System.in);
        int chosenPort = teclado.nextInt();teclado.nextLine();

        // open and configure the port
        SerialPort puerto = puertos.get(chosenPort-1);
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
                try{label.setText(data.nextLine());}catch(Exception e){}
        }
	}

}
