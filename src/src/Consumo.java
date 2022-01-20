package src;

import java.util.Calendar;

public class Consumo {
    
    int año;
    int mes;
    String dia;

    int hora;
    int minuto;
    int segundo;

    int consumo; //segundos de uso de luz









    public Consumo() {

        Calendar calendario = Calendar.getInstance();

        this.año =calendario.get(Calendar.YEAR);
        this.mes =calendario.get(Calendar.MONTH);
        this.dia = diaSemana(calendario.get(Calendar.DAY_OF_WEEK));
  
        this.hora = calendario.get(Calendar.HOUR_OF_DAY);
        this.minuto =calendario.get(Calendar.MINUTE);
        this.segundo = calendario.get(Calendar.SECOND);
        
    }

public Consumo(int i) {
    }

private String diaSemana(int diaSemana){
    String diaSemanaString=null;

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

    public void consumo() {
        
        consumo=hora*3600+minuto*60+segundo;


    }

    public int getConsumo() {
        return consumo;
    }

 
    



}
