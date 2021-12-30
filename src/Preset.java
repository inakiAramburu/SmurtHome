import java.io.Serializable;

public class Preset implements Serializable {
	
	String nombre;
	int temperatura;
	int persianas;
	int luz;
	public Preset(String nombre, int temperatura, int persianas, int luz) {
		
		this.nombre = nombre;
		this.temperatura = temperatura;
		this.persianas = persianas;
		this.luz = luz;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getPersianas() {
		return persianas;
	}
	public void setPersianas(int persianas) {
		this.persianas = persianas;
	}
	public int getLuz() {
		return luz;
	}
	public void setLuz(int luz) {
		this.luz = luz;
	}


    public void mostrarDatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Temperatura: " + temperatura);
		System.out.println("Persianas: " + persianas);
		System.out.println("Luz: " + luz);
    }
	
	
	
	
	
	
	
	
	
	
	
	
}
