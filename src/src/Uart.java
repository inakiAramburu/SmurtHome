package src;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import com.fazecast.jSerialComm.SerialPort;

public class Uart {

	public Uart() {

		// determine which serial port to use
		SerialPort puertos[] = SerialPort.getCommPorts();
		System.out.println("Select a port:");
		int i = 1;
		for (SerialPort puerto : puertos) {
			System.out.println(i++ + ". " + puerto.getSystemPortName());
		}
		Scanner s = new Scanner(System.in);
		int chosenPort = s.nextInt();

		// open and configure the port
		SerialPort puerto = puertos[chosenPort - 1];
		if (puerto.openPort()) {
			System.out.println("Successfully opened the port.");
		} else {
			System.out.println("Unable to open the port.");
			return;
		}
		puerto.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

		Integer datos[] = new Integer[4];

		byte bD[] = new byte[4];
		Scanner data = new Scanner(puerto.getInputStream());
		// enter into an infinite loop that reads from the port and updates the GUI
		while (data.hasNextLine()) {
			String readData = new String(data.nextLine());
			System.out.println(readData);

			// System.out.println("\r\nTemp: ");
			datos[0] = 20;

			// System.out.println("\r\nLuz: ");
			datos[1] = 2;

			// System.out.println("\r\nPers: "); // NOTA modo automatico
			datos[2] = 1;

			// System.out.println("\r\n automatico: ");
			datos[3] = 0;
			// Convert Integer number to byte value
			for (i = 0; i < datos.length; i++)
				bD[i] = datos[i].byteValue();

			puerto.writeBytes(bD, datos.length);
		}

	}

	public static void main(String[] args) {
		Uart programa = new Uart();

	}

}
