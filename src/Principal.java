import jssc.SerialPortList;

//https://code.google.com/archive/p/java-simple-serial-connector/wikis/jSSC_examples.wiki



public class Principal {

	public Principal() {

	}

	// @Override
	// public int getListeningEvents() {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public void serialEvent(SerialPortEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }

	public static void main(String[] args) {
		Principal programa = new Principal();
		System.out.println("hola");
		
		// mostrar una lista de los puertos disponibles en consola
		String[] portNames = SerialPortList.getPortNames();
		for (int i = 0; i < portNames.length; i++) {
			System.out.println(portNames[i]);
		}

	}
}
