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

public class Radio implements Player {
	//
	private String name; 
	private boolean powerOn;
	private int volumeLevel; 
	
	private Narrator narrator; 
	
	public Radio(String name) {
		// 
		this.name = name; 
		this.powerOn = false; 
		this.volumeLevel = 1; 
		
		this.narrator = new Narrator(this, TalkingAt.Right); 
	}

	public String getName() {
		return name; 
	}
	
	public boolean isPowerOn() {
		return this.powerOn; 
	}
	
	public void turnOn() {
		//
		this.powerOn = true; 
		this.volumeLevel = 1; 
		this.broadcasting(); 
	}
	
	public void turnOff() {
		// 
		this.powerOn = false; 
		this.volumeLevel = 1; 
	}
	
	public void turnVolumeUp() {
		// 
		narrator.say("소리를 높입니다."); 
		volumeLevel++; 
		broadcasting();
	}
	
	public void turnVolumeDown() {
		// 
		narrator.say("소리를 낮춥니다."); 
		volumeLevel--; 
		broadcasting();
	}
	
	public int getVolumeLevel() {
		return volumeLevel; 
	}
	
	private void broadcasting() {
		//
		narrator.say("[볼륨:" + volumeLevel + "] 아, 아, 오늘의 뉴스를 말씀드리겠습니다."); 
	}
}