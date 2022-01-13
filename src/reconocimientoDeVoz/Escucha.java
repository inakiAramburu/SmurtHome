package reconocimientoDeVoz;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Cmop
 */
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import javax.speech.recognition.RuleGrammar;

import src.Controlador;

public class Escucha extends ResultAdapter {

	static Recognizer recognizer;
	String gst;
	static boolean microfono = false;
	static Controlador controlador;

	public Escucha(Controlador controlador) {
		this.controlador = controlador;
	}

    @Override
	public void resultAccepted(ResultEvent re) {

		if (microfono) {

			try {
				Result res = (Result) (re.getSource());
				ResultToken tokens[] = res.getBestTokens();

				List<String> lista = new ArrayList<String>();

				for (int i = 0; i < tokens.length; i++) {
					gst = tokens[i].getSpokenText();
					lista.add(gst);
					System.out.print(gst + " ");
				}
				System.out.println();
				if (gst.equals("salir")) {
					recognizer.deallocate();
					System.out.println("Hasta la proxima Cmop 'salir'!");
					System.exit(0);

				}
				if (lista.get(0).equals("Temperatura")) {
					// recognizer.deallocate();
					
					if (lista.get(1) != null) {
						if (Integer.parseInt(lista.get(1)) >= 17 && Integer.parseInt(lista.get(1)) <= 30) {

							controlador.getconector().firePropertyChange("recarga", "temperatura",Integer.parseInt(lista.get(1)));

						} else {
							System.out.println("Temperatura fuera de rango");
						}

					}

				}if (lista.get(0).equals("enciende la luz")) {
					// recognizer.deallocate();
					System.out.println("Enciende la luz");
					if (lista.get(1) != null) {
						

					}

				} 
				else {
					recognizer.suspend();

					recognizer.resume();
				}
			} catch (Exception ex) {
				System.out.println("Ha ocurrido algo inesperado " + ex);
			}
		} else {
			System.out.println("microfono no activado");
		}
	}

	public void setMicrofono(int microfono) {
		if (microfono == 1) {
			this.microfono = true;
		} else {
			this.microfono = false;
		}

	}

	public void escucha(int microfono) {
		// public static void main(){
		if (microfono == 1) {
			this.microfono = true;
		} else {
			this.microfono = false;
		}

		if (this.microfono) {
			try {
				recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
				recognizer.allocate();

				FileReader grammar1 = new FileReader("librerias/SimpleGrammarES2.txt");

				RuleGrammar rg = recognizer.loadJSGF(grammar1);
				rg.setEnabled(true);

				recognizer.addResultListener(new Escucha(controlador));

				System.out.println("Empieze Dictado");
				recognizer.commitChanges();

				recognizer.requestFocus();
				recognizer.resume();
			} catch (Exception e) {
				System.out.println("Exception en " + e.toString());
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
