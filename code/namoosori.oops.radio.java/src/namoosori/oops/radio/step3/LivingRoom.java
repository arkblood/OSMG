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

public class LivingRoom implements Player {
	//
	private Child playingChild; 
	private Radio radio; 

	private Narrator narrotor; 
	
	public LivingRoom() {
		//
		this.narrotor = new Narrator(this, TalkingAt.Left); 
	}
	
	public String getName() {
		// 
		return "livingRoom"; 
	}
	
	public void enter(Child child) {
		//
		narrotor.say(String.format("거실에 아이(%s)가 들어오는군.", child.getName()));
		this.playingChild = child; 
	}
	
	public Child getChild() {
		//
		return playingChild; 
	}
	
	public void setUp(Radio radio) {
		//
		narrotor.say(String.format("거실에 라디오(%s)를 설치합니다.", radio.getName()));
		this.radio = radio;
	}
	
	public Radio getRadio() {
		//
		return radio; 
	}	
}