package uart;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import src.Preset;

public class Uart {
	static Preset preset;
	SerialPort puerto;

	public Uart() {
		// this.preset=preset;

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

		// ver la velocidad de transmision
		System.out.println("Baud rate: " + puerto.getBaudRate());
	}

	public void start(Uart uart, Preset oraingoa) {
		Uart.preset=oraingoa;
		Thread hilo = new Thread(new Runnable() {
			@Override

			public void run() {
				int i = 0;
				try {

					System.out.println("inicio");
					while (true) {
						//preset=getPreset();
						
						uart.enviar();
						System.out.println( "hascodeuart: "+ preset.hashCode());
						System.out.println("hascode Uart.preset: "+Uart.preset.hashCode());
						// printea la clase preset
						System.out.println(i++ + " " + preset);
						uart.leer();
						//Thread.sleep(1000);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		hilo.start();

	}

	public void enviar() {
		// determine which serial port to use

		Integer datos[] = new Integer[4];

		byte bD[] = new byte[4];

		datos[0] = preset.getTemperatura();

		datos[1] = preset.getIntensidad();

		datos[2] = preset.getPersiana();

		datos[3] = preset.getAutomatico();
		// Convert Integer number to byte value
		for (int i = 0; i < datos.length; i++)
			bD[i] = datos[i].byteValue();

		puerto.writeBytes(bD, datos.length);

	}

	public void leer() {

		byte bD[] = new byte[1];
		int dato;
		
		puerto.readBytes(bD, 1);

		dato = (bD[0]-48);

		if(dato==1) {
			preset.setPersiana(0);
		}

	}

	public void setPreset(Preset preset) {
		Uart.preset = preset;
	}
}
