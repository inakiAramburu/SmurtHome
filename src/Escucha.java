/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cmop
 */
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import javax.speech.recognition.RuleGrammar;

public class Escucha extends ResultAdapter {

	static Recognizer recognizer;
	String gst;

	@Override
	public void resultAccepted(ResultEvent re) {
	

		try {
			Result res = (Result) (re.getSource());
			ResultToken tokens[] = res.getBestTokens();

			List<String>lista=new ArrayList<>();
			for (int i = 0; i < tokens.length; i++) {
				  = tokens[i].getSpokenText();
				lista.add(gst);
				System.out.print(gst + " ");
				//lee.voz(gst.toString());
			}
			System.out.println();
			if (gst.contains("salir")) {
				recognizer.deallocate();
				
				System.out.println("Hasta la proxima Cmop 'salir'!");
				
				System.exit(0);
			} else {
				recognizer.suspend();
				
				recognizer.resume();
			}
		} catch (Exception ex) {
			System.out.println("Ha ocurrido algo inesperado " + ex);
		}
	}

	public  void escuchar() {
		try {
			recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
			recognizer.allocate();

			FileReader grammar1 = new FileReader("Diccionario/SimpleGrammarES2.txt");

			RuleGrammar rg = recognizer.loadJSGF(grammar1);
			rg.setEnabled(true);

			recognizer.addResultListener(new Escucha());

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
