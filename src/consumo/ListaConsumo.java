package consumo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.Preset;

public class ListaConsumo {
    // aÃ±o , mes ,dia, consumo
    static ListaConsumo lista;
    static Map<Integer, Map<Integer, Map<String, Integer>>> listaConsumos = new HashMap<Integer, Map<Integer, Map<String, Integer>>>();
    static Map<Integer, Map<String, Integer>> mes = new HashMap<Integer, Map<String, Integer>>();
    static Map<String, Integer> dia = new HashMap<String, Integer>();

    private ListaConsumo() {

    }

    public synchronized static ListaConsumo getListaConsumo() {

        if (lista == null) {
            lista = new ListaConsumo();
        }

        return lista;

    }

    // mostrar datos por consola
    public void mostrarDatos() {
        for (Map.Entry<Integer, Map<Integer, Map<String, Integer>>> año : listaConsumos.entrySet()) {
            for (Map.Entry<Integer, Map<String, Integer>> mes : año.getValue().entrySet()) {
                for (Map.Entry<String, Integer> dia : mes.getValue().entrySet()) {
                    System.out.println("aÃ±o: " + año.getKey() + " mes: " + mes.getKey() + " dia: " + dia.getKey()
                            + " consumo: " + dia.getValue());
                }
            }
        }
    }

    public void meterDatos(Consumo consumoDia) throws ClassNotFoundException {
        int consumoAnterior = 0;
      
        this.listaConsumos=leerDatosConsumo();
        

        // listaConsumos.get(consumoDia.getAno()).get(consumoDia.getMes()).get(consumoDia.getDia())
        if (listaConsumos.get(consumoDia.getAno()) != null) {
            if (listaConsumos.get(consumoDia.getAno()).get(consumoDia.getMes()) != null) {
                if (listaConsumos.get(consumoDia.getAno()).get(consumoDia.getMes()).get(consumoDia.getDia()) != null) {
                    consumoAnterior = listaConsumos.get(consumoDia.getAno()).get(consumoDia.getMes())
                            .get(consumoDia.getDia());
                }
            }
            System.out.println("consumoAnterior: " + consumoAnterior);
        }
        // meter en listaConsumos el aÃ±o el mes el dia y el consumo
        listaConsumos.put(consumoDia.getAno(), mes);
        mes.put(consumoDia.getMes(), dia);
        dia.put(consumoDia.getDia(), consumoDia.consumo + consumoAnterior);

        guardarDatosConsumo();
    }

    private void guardarDatosConsumo() {

        FileOutputStream fichero = null;

        try {
            fichero = new FileOutputStream("datosConsumo.txt");
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



    private Map<Integer, Map<Integer, Map<String, Integer>>> leerDatosConsumo() throws ClassNotFoundException {

        FileInputStream ficheroEntrada = null;
        Map<Integer, Map<Integer, Map<String, Integer>>> listaConsumos = new HashMap<Integer, Map<Integer, Map<String, Integer>>>();
        try {
            ficheroEntrada = new FileInputStream("datosConsumo.txt");
            try (ObjectInputStream tuberia = new ObjectInputStream(ficheroEntrada)) {
                listaConsumos = (Map<Integer, Map<Integer, Map<String, Integer>>>) tuberia.readObject();
            }
            

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return listaConsumos;
    }




}
