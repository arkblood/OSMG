/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.player;

import namoosori.oops.radio.util.Narrator;
import namoosori.oops.radio.util.Player;
import namoosori.oops.radio.util.TalkingAt;

public class Child implements Player {
	// 
	private String name; 
	private int age; 

	private Narrator narrator;

	public Child(String name, int age) {
		//
		this.name = name;  
		this.age = age; 
		
		this.narrator = new Narrator(this, TalkingAt.Middle); 
	}
	
	public String getName() {
		//
		return name; 
	}
	
	public boolean canYouTurnOnRadio() {
		//
		narrator.say("라디오를 켤 수 있냐구요?");
		
		if(canITurnOnRadio()) {
			narrator.say("예, 켤 수 있어요."); 
			return true;  
		} else {
			narrator.say("아뇨, 아직 어려서 켤 수 없어요."); 
			return false;
		}
	}
	
	public boolean canYouAdjustVolume() {
		//
		narrator.say("소리를 조정할 수 있냐구요?");
		
		if(canIAdjustVolume()) {
			narrator.say("예, 할 수 있어요."); 
			return true;  
		} else {
			narrator.say("아뇨, 아직 어려서 할 수 없어요."); 
			return false; 
		}
	}

	public void turnOnRadio(Radio radio) {
		// 
		if (!canITurnOnRadio()) {
			narrator.say("저는 라디오를 켤 수 없어요.");
			return; 
		}

		if (radio.isPowerOn()) {
			narrator.say("이미 켜져 있는데요..."); 
			return; 
		}
		
		narrator.say("예, 켤께요."); 
		radio.turnOn();
	}

	public void turnVolumeUp(Radio radio) {
		// 
		if (!canIAdjustVolume()) {
			narrator.say("저는 라디오 소리를 조정할 수 없어요.");
			return; 
		}
		
		narrator.say ("예, 소리를 높일께요."); 
		radio.turnVolumeUp(); 
	}

	private boolean canITurnOnRadio() {
		// 
		if (age > 4) {
			return true; 
		}
		
		return false; 
	}
	
	private boolean canIAdjustVolume() {
		// 
		if (age > 4) {
			return true; 
		}
		
		return false; 
	}
}
