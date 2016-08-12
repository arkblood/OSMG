/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.stage;

import namoosori.oops.radio.step4.player.Child;
import namoosori.oops.radio.step4.player.Mom;
import namoosori.oops.radio.step4.player.Radio;
import namoosori.oops.radio.util.Narrator;
import namoosori.oops.radio.util.Player;
import namoosori.oops.radio.util.TalkingAt;

public class Director implements Player {
	//
	private String name; 
	private Mom mom; 
	private LivingRoom livingRoom; 
	
	private Narrator narrator; 

	public Director() {
		// 
		this.name = "KimPD"; 
		this.narrator = new Narrator(this, TalkingAt.Left); 
		this.prepareScenario(); 
	}
	
	public String getName() {
		return name; 
	}
	
	public void playTurnOnRadioScene() {
		// 
		narrator.say(String.format("%s씨, 라디오 들으면서 일하실래요?", mom.getName())); 
		mom.listenToRadio(); 
	}
	
	public void playAdjustVolumeScene() {
		// 
		narrator.say(String.format("%s씨, 소리 좀 조정해주실래요?", mom.getName())); 
		mom.adjustRadioVolume();
	}
	
	private void prepareScenario() {
		//
		narrator.say("극을 진행하기 위해 무대를 준비합니다..."); 
		this.livingRoom = buildLivingRoom(); 
		this.mom = inviteMinsooMom("Yeongmi", livingRoom); 
		
		Child minsoo = mom.callSon("Minsoo"); 
		livingRoom.enter(minsoo); 
		
		Radio tivoli = shopRadio("Tivoli"); 
		livingRoom.setUp(tivoli);
	}

	private LivingRoom buildLivingRoom() {
		//
		narrator.say("거실을 만듭니다."); 
		LivingRoom livingRoom = new LivingRoom(); 
		return livingRoom; 
	}
	
	private Mom inviteMinsooMom(String name, LivingRoom livingRoom) {
		// 
		narrator.say(String.format("%s씨를 초대합니다.", name)); 
		return new Mom(name, livingRoom); 
	}
	
	private Radio shopRadio(String brandName) {
		//
		narrator.say(String.format("%s 브랜드 라디오을 사옵니다.", brandName));
		return new Radio(brandName); 
	}
}
