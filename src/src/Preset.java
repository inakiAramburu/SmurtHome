package src;
import java.io.Serializable;

public class Preset implements Serializable {
	
	

	String nombre;
	int temperatura=20;
    int intensidad=0;
    int persiana=0;
    int microfono=0;
    int automatico=0;
    
	
	public Preset(String nombre, int temperatura, int intensidad, int persiana,int microfono,int automatico) {
		
		this.nombre = nombre;
		this.temperatura = temperatura;
		this.intensidad = intensidad;
		this.persiana = persiana;
		this.microfono = microfono;
		this.automatico = automatico;
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
	public void setMicrofono(int microfono) {
        this.microfono=microfono;
    }


    public void setAutomatico(int automatico) {
		this.automatico=automatico;
	}


	public int getPersiana() {
		return persiana;
	}
	public void setPersiana(int persiana) {
		this.persiana = persiana;
	}
	public int getIntensidad() {
		return intensidad;
	}
	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}
	public int getMicrofono() {
        return this.microfono;
    }


    public int getAutomatico() {
        return this.automatico;
    }

    public void mostrarDatos() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Temperatura: " + temperatura);
		System.out.println("Intensidad: " + intensidad);
		System.out.println("Persiana: " + persiana);
		System.out.println("Microfono: " + microfono);
		System.out.println("Automatico: " + automatico);
    }


   


    
	
	
	
	
	
	
	
	
	
	
	
	
}
