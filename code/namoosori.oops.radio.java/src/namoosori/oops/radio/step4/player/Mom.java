/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.player;

import java.util.ArrayList;
import java.util.List;

import namoosori.oops.radio.step4.stage.LivingRoom;
import namoosori.oops.radio.util.Narrator;
import namoosori.oops.radio.util.Player;
import namoosori.oops.radio.util.TalkingAt;

public class Mom implements Player {
	//
	private String name; 
	private List<Child> adorableChildren; 
	private LivingRoom livingRoom; 
	
	private Narrator narrator; 

	public Mom(String name, LivingRoom livingRoom) {
		//
		this.name = name; 
		this.livingRoom = livingRoom; 
		this.inviteSons();
		
		this.narrator = new Narrator(this, TalkingAt.Left); 
	}
	
	public String getName() {
		return name; 
	}
	
	public Child callSon(String name) {
		// 
		for (Child son : adorableChildren) {
			if (son.getName().equals(name)) {
				return son; 
			}
		}
		
		throw new RuntimeException("No such a son named " + name); 
	}
	
	public void listenToRadio() {
		//
		narrator.say("그럴까요, 라디오를 듣겠습니다."); 

		if(!livingRoom.containRadio()) {
			narrator.say("라디오가 없네요...");
			return; 
		}
		
		Radio radio = livingRoom.findRadio(); 
			
		if (radio.isPowerOn()) {
			narrator.say("라디오가 이미 켜져있네...");
			return;
		}
		
		String childName = findChildInOrder(1).getName();

		if (livingRoom.existChild(childName)) {
			//
			Child smartChild = livingRoom.findChild(childName);
			narrator.say(smartChild.getName() + ", 라디오 켤 수 있겠니?");

			if (smartChild.canYouTurnOnRadio()) {
				narrator.say("그래, 그럼 라디오 좀 켜줄래?");
				smartChild.turnOnRadio(radio);
				return; 
			} 
		}
		
		this.turnOnRadioByMyself(radio);
	}
	
	public void adjustRadioVolume() {
		//
		narrator.say("소리를 조정할께요.");
		
		if(!livingRoom.containRadio()) {
			narrator.say("라디오가 없네요...");
			return; 
		}
		
		Radio radio = livingRoom.findRadio(); 
		
		if (!radio.isPowerOn()) {
			narrator.say("라디오가 꺼져있네요. 먼져 켜신 후 소리를 조정하세요."); 
			return; 
		}

		narrator.say("그럴까요, 소리를 조정할께요."); 

		if (!feelAsLowVolume(radio)) {
			return; 
		}
		
		String childName = findChildInOrder(1).getName();
		if (livingRoom.existChild(childName)) {
			//
			Child smartSon = livingRoom.findChild(childName);
			if (smartSon.canYouAdjustVolume()) {
				adjustRadioVolumeBySon(smartSon, radio); 
				return; 
			}
		}
		
		adjustRadioVolumeByMyself(radio); 
	}
	
	private void adjustRadioVolumeBySon(Child child, Radio radio) {
		//
		while(feelAsLowVolume(radio)) {
			this.waitAndListen(4); 
			narrator.say(child.getName() + ", 소리 좀 키워줄래?"); 
			child.turnVolumeUp(radio);
		}
	}
	
	private void adjustRadioVolumeByMyself(Radio radio) {
		//
		while(feelAsLowVolume(radio)) {
			waitAndListen(4); 
			narrator.say("소리를 좀 더 키워야겠네...."); 
			radio.turnVolumeUp();
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

	private void turnOnRadioByMyself(Radio radio) {
		// 
		narrator.say("직접 라디오를 켜야겠군...."); 
		radio.turnOn();
	}
	
	private Child findChildInOrder(int order) {
		// 
		if(this.adorableChildren.size() < (order-1)) {
			throw new RuntimeException("아들이 몇 명인지 몰라요... ㅠㅠ "); 
		}
		
		return adorableChildren.get(order-1); 
	}
	
	private void waitAndListen(int seconds) {
		// 
		narrator.say("흠... 잠시 들어보자..."); 
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void inviteSons() {
		// 
		this.adorableChildren = new ArrayList<Child>(); 
		this.adorableChildren.add(new Child("Minsoo", 5)); 
		this.adorableChildren.add(new Child("Minki", 3)); 
	}
}