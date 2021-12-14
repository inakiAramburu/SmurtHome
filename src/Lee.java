/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cmop
 */
import javax.speech.AudioAdapter;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class Lee {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
	
		
	
		try {

			//System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory");
			System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

		//Voice voice = VoiceManager.getInstance().getVoice("alan");
		Voice voice = VoiceManager.getInstance().getVoice("kevin16");
		//print all voices
		Voice[] voicelist =VoiceManager.getInstance().getVoices();
		for(int i=0;i<voicelist.length;i++)
		{
			System.out.println("#Voice: "+voicelist[i].getName());
		}

		if (voice != null) {
			voice.allocate();
			System.out.println("Voice Rate: " + voice.getRate());
			System.out.println("Voice Pitch: " + voice.getPitch());
			System.out.println("Voice Volume: " + voice.getVolume());

				


			Boolean status=voice.speak("hello world");
			System.out.println("Status: "+status);
			voice.deallocate();


		//	voice.speak("Hello, I am Lee");
			voice.deallocate();
		}else{
			System.out.println("Error getting voice");
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}



			



	}


	void tts(String text) {
		try {
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}