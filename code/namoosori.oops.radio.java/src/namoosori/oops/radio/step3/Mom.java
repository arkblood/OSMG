/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step3;

import namoosori.oops.radio.util.Narrator;
import namoosori.oops.radio.util.Player;
import namoosori.oops.radio.util.TalkingAt;

public class Mom implements Player {
	//
	private String name; 
	private Child adorableChild; 
	private LivingRoom livingRoom; 
	
	private Narrator narrator; 

	public Mom(String name, LivingRoom livingRoom) {
		//
		this.name = name; 
		this.adorableChild = new Child("Minsoo", 5);
		this.livingRoom = livingRoom; 
		this.narrator = new Narrator(this, TalkingAt.Left); 
	}
	
	@Override
	public String getName() {
		return name; 
	}
	
	public Child callSon() {
		return adorableChild; 
	}
	
	public void listenToRadio() {
		//
		narrator.say("그럴까요, 라디오를 듣겠습니다."); 

		Radio radio = livingRoom.getRadio(); 
		
		narrator.say(adorableChild.getName() + ", 라디오 켤 수 있겠니?");

		if (adorableChild.canYouTurnOnRadio()) {
			narrator.say("그래, 그럼 라디오 좀 켜줄래?");
			adorableChild.turnOnRadio(radio);
			return; 
		} 
	}
	
	public void adjustRadioVolume() {
		//
		narrator.say("소리를 조정할께요.");
		
		Radio radio = livingRoom.getRadio(); 
		
		if (!radio.isPowerOn()) {
			narrator.say("이런 라디오가 꺼져있네요. 먼저 켠 후 소리를 조정해야겠네요."); 
			return; 
		}

		while(feelAsLowVolume(radio)) {
			narrator.sayAndSleep("흠... 잠시 들어보자...", 4); 
			narrator.say(adorableChild.getName() + ", 소리 좀 키워줄래?"); 
			adorableChild.turnVolumeUp(radio);
		}
	}
	
	private boolean feelAsLowVolume(Radio radio) {
		// 
		if (radio.getVolumeLevel() < 4) {
			narrator.say("...(listen)..."); 
			narrator.say("소리가 작은 것 같네..."); 
			return true; 
		} else {
			narrator.say("소리가 적당하네..."); 
			return false;
		}
	}
}