/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step1;

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
	
	public void turnOnRadio(Radio radio) {
		// 
		narrator.say("예, 켤께요."); 
		radio.turnOn();
	}

	private boolean canITurnOnRadio() {
		// 
		if (age > 4) {
			narrator.sayAndSleep("내가 다섯 살이니 라디오 정도는 켜야겠지.. ", 3); 
			return true; 
		}
		
		narrator.say("난 아직 너무 어려서 라디오를 만지면 안되잖아...");  
		return false; 
	}
}