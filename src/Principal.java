import com.fazecast.jSerialComm.SerialPort;

public class Principal {
	SerialPort[] puertos;
	public Principal() {
		puertos = SerialPort.getCommPorts();
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
