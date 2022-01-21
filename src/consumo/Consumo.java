package consumo;

import java.util.Calendar;

public class Consumo {
    
    int a�o;
    int mes;
    String dia;

    int hora;
    int minuto;
    int segundo;
    int tiempoTotal;

    int consumo; //segundos de uso de luz



    public Consumo() {

        Calendar calendario = Calendar.getInstance();

        this.a�o =calendario.get(Calendar.YEAR);
        this.mes =calendario.get(Calendar.MONTH);
        this.dia = diaSemana(calendario.get(Calendar.DAY_OF_WEEK));
  
        this.hora = calendario.get(Calendar.HOUR_OF_DAY);
        this.minuto =calendario.get(Calendar.MINUTE);
        this.segundo = calendario.get(Calendar.SECOND);
        
    }

public Consumo(int diferencia) {

    Calendar calendario = Calendar.getInstance();
    this.a�o =calendario.get(Calendar.YEAR);
    this.mes =calendario.get(Calendar.MONTH);
    this.dia = diaSemana(calendario.get(Calendar.DAY_OF_WEEK));

    

    this.consumo=diferencia;

    }

private String diaSemana(int diaSemana){
    String diaSemanaString=null;
    diaSemana--;
    switch (diaSemana){
        case 1:
            diaSemanaString="Lunes";
            break;
        case 2:
            diaSemanaString="Martes";
            break;
        case 3:
            diaSemanaString="Miercoles";
            break;
        case 4:
            diaSemanaString="Jueves";
            break;
        case 5:
            diaSemanaString="Viernes";
            break;
        case 6:
            diaSemanaString="Sabado";
            break;
        case 7:
            diaSemanaString="Domingo";
            break;
    }


    return diaSemanaString;
}







    void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getHora() {
        return this.hora;
    }

    public void setHora(int i) {
        this.hora = i;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public void setMinuto(int i) {
        this.minuto = i;
    }

    public int getSegundo() {
        return this.segundo;
    }

    public void setSegundo(int i) {
        this.segundo = i;
    }

    public int getTiempoTotal() {
        
        tiempoTotal=hora*3600+minuto*60+segundo;
        return tiempoTotal;

    }
    public int getAno() {
        return this.a�o;
    }
    public int getMes() {
        return this.mes;
    }

    public int getConsumo() {
        return consumo;
    }
    public String getDia() {
        return this.dia;
    }

    public void mostarConsumo() {
        System.out.println("hora: "+hora+" minuto: "+minuto+" segundo: "+segundo);
    }

    public int compare(Consumo consumoApagado) {

        return consumoApagado.getTiempoTotal() -this.getTiempoTotal();
    }

 
    



}
