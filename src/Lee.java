/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cmop
 */
import javax.speech.*;
import javax.speech.synthesis.*;
import java.util.*;

public class Lee {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {

			
			

			SynthesizerModeDesc required = new SynthesizerModeDesc();
			required.setLocale(Locale.ROOT);

			//Voice voice = new Voice(null, Voice.GENDER_FEMALE, Voice.GENDER_FEMALE, null);
			Voice voice = new Voice(null, Voice.GENDER_MALE, Voice.GENDER_MALE, null);

			required.addVoice(voice);

			Synthesizer synth = Central.createSynthesizer(null);

			synth.allocate();
			synth.resume();

			synth.speakPlainText("hola que tal grupo 4 de PBL, jijijiji", null);
			//synth.speakPlainText("na na na na na na baatmaaaaan na na batmaaaaaaan", null);
			//synth.speakPlainText("os voy a matar a todos xd", null);
			synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
			synth.deallocate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}