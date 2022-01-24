package src;

import consumo.Consumo;
import consumo.ListaConsumo;

public class Hilo {
    
    static Preset preset;


    public Hilo( Preset preset) {
        this.preset=preset;


        // TODO Auto-generated constructor stub
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Consumo consumoEncendido = null;
                    Consumo consumoApagado = null;
                    Boolean comprobado = false;

                    while (true) {
                        Thread.sleep(1000);
                        System.out.println("Hilo "+Hilo.preset);
                        if (Hilo.preset.getIntensidad() >= 1 && comprobado == false) {
                            consumoEncendido = new Consumo();
                            comprobado = true;
                        }
                        if (Hilo.preset.getIntensidad() == 0 && comprobado == true) {
                            consumoApagado = new Consumo();
                            comprobado = false;

                            consumoEncendido.mostarConsumo();
                            consumoApagado.mostarConsumo();

                            consumoEncendido.getTiempoTotal();
                            consumoApagado.getTiempoTotal();

                            int diferencia = consumoEncendido.compare(consumoApagado);
                            System.out.println("consumo total " + consumoEncendido.compare(consumoApagado));

                            Consumo total = new Consumo(diferencia);

                            ListaConsumo listaConsumos = ListaConsumo.getListaConsumo();

                            listaConsumos.meterDatos(total);
                            listaConsumos.mostrarDatos();

                        }

                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        });

        hilo.start();

    }




    void setPreset(Preset preset){
        this.preset=preset;
    }


}
