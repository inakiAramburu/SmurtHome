package consumo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ListaConsumo {
    // año , mes ,dia, consumo
    static ListaConsumo lista;
    //static Map<Integer, Map<Integer, Map<String, Integer>>> listaConsumos = new HashMap<Integer, Map<Integer, Map<String, Integer>>>();
    //static Map<Integer, Map<String, Integer>> mes = new HashMap<Integer, Map<String, Integer>>();
    //static Map<String, Integer> dia = new HashMap<String, Integer>();

Map <LocalDate,Integer> listaConsumos = new HashMap<LocalDate,Integer>();

    private ListaConsumo() {

    }

    public synchronized static ListaConsumo getListaConsumo() {

        if (lista == null) {
            lista = new ListaConsumo();
        }

        return lista;

    }

    public void meterDatos(Consumo consumo) {
       
        int consumoAnterior=0;
        try {
            listaConsumos=leerDatosConsumo();
            consumoAnterior=listaConsumos.get(consumo.fecha);
            System.out.println("consumo anterior "+consumoAnterior);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        listaConsumos.put(consumo.getFecha(),consumo.getConsumo()+consumoAnterior);


        guardarDatosConsumo();

    }


    // mostrar datos por consola
    public void mostrarDatos() {
        System.out.println("Lista de consumos");
        for (Map.Entry<LocalDate, Integer> entry : listaConsumos.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    
    

    
    private void guardarDatosConsumo() {

        FileOutputStream fichero = null;

        try {
            fichero = new FileOutputStream("datosConsumo.bin");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(listaConsumos);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }



    private Map<LocalDate, Integer> leerDatosConsumo() throws ClassNotFoundException {

        FileInputStream ficheroEntrada = null;
         listaConsumos = new HashMap<LocalDate,Integer>();
        try {
            ficheroEntrada = new FileInputStream("datosConsumo.bin");
            try (ObjectInputStream tuberia = new ObjectInputStream(ficheroEntrada)) {
                listaConsumos =  (Map<LocalDate, Integer>) tuberia.readObject();
            }
            

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return listaConsumos;
    }




}
