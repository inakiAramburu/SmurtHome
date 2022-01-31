package reconocimientoDeVoz;

import java.util.logging.Level;
import java.util.logging.Logger;

import src.Preset;

public class Runee implements Runnable {

    Preset oraingoa;
    public Runee(Preset oraingoa) {
        this.oraingoa = oraingoa;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    int i=0;
        while(oraingoa.getMicrofono()==0){
            
            try {
                Thread.sleep(1000);
                System.out.println("thread is running... "+i++);
                System.out.println(oraingoa.getNombre());
            } catch (InterruptedException ex) {
                Logger.getLogger(Runee.class.getName()).log(Level.SEVERE, null, ex);
            }

           






             
        }
        
    }
    
}
