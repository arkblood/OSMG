package namoosori.oops.radio.step1;

public class StoryAssistant {
	// 
	
	public static void main(String[] args) {
		// 
		startStory(); 
	}
	
	public static void startStory() {
		// 
		Radio radio = new Radio("Tivoli"); 
		Mom mom = new Mom("Yeongmi"); 
		
		mom.listenToRadio(radio);
	}
}