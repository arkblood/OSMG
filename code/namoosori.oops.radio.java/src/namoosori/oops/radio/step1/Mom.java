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

public class Mom implements Player {
	//
	private String name; 
	private Child adorableChild; 
	
	private Narrator narrator; 

	public Mom(String name) {
		//
		this.name = name; 
		this.adorableChild = new Child("minsoo", 5); 
		this.narrator = new Narrator(this, TalkingAt.Left); 
	}
	
	public String getName() {
		return name; 
	}
	
	public void listenToRadio(Radio radio) {
		//
		narrator.say("그럴까요, 라디오를 듣겠습니다."); 

		narrator.say(adorableChild.getName() + ", 라디오 켤 수 있겠니?");

		if (adorableChild.canYouTurnOnRadio()) {
			narrator.say("그래, 그럼 라디오 좀 켜줄래?");
			adorableChild.turnOnRadio(radio);
			return; 
		} 
	}
}