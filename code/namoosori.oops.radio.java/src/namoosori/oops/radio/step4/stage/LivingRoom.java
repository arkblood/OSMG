/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.stage;

import java.util.ArrayList;
import java.util.List;

import namoosori.oops.radio.step4.exception.NoChildException;
import namoosori.oops.radio.step4.exception.NoRadioException;
import namoosori.oops.radio.step4.player.Child;
import namoosori.oops.radio.step4.player.Radio;
import namoosori.oops.radio.util.Narrator;
import namoosori.oops.radio.util.Player;
import namoosori.oops.radio.util.TalkingAt;

public class LivingRoom implements Player {
	//
	private List<Child> playingChildren; 
	private Radio radio; 

	private Narrator narrotor; 
	
	public LivingRoom() {
		//
		this.playingChildren = new ArrayList<Child>(); 
		this.narrotor = new Narrator(this, TalkingAt.Left); 
	}
	
	public String getName() {
		// 
		return "livingRoom"; 
	}
	
	public void enter(Child child) {
		//
		narrotor.say(String.format("거실에 아이(%s)가 들어오는군.", child.getName()));
		this.playingChildren.add(child); 
	}
	
	public boolean existChild(String name) {
		// 
		for(Child child : playingChildren) {
			// 
			String childName = child.getName(); 
			if (childName.equals(name)) {
				return true; 
			}
		}
		
		return false; 
	}
	
	public Child findChild(String name) {
		//
		for(Child child : playingChildren) {
			// 
			String childName = child.getName(); 
			if (childName.equals(name)) {
				return child; 
			}
		}
		
		throw new NoChildException(name + "는 여기 없어요."); 
	}
	
	public void setUp(Radio radio) {
		//
		narrotor.say(String.format("거실에 라디오(%s)를 설치합니다.", radio.getName()));
		this.radio = radio;
	}
	
	public boolean containRadio() {
		// 
		if (radio != null) {
			return true; 
		}
		
		return false; 
	}
	
	public Radio findRadio() {
		//
		if (radio == null) {
			throw new NoRadioException("Radio가 없어요.");  
		}
		
		return radio; 
	}	
}