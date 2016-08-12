package namoosori.oops.radio.step3;

public class StoryAssistant {
	// 
	
	public static void main(String[] args) {
		// 
		startStory(); 
	}
	
	public static void startStory() {
		// 
		Director kimPD = new Director(); 
		kimPD.playTurnOnRadioScene(); 
		kimPD.playAdjustVolumeScene();
	}
}