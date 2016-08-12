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

public class Radio implements Player {
	//
	private static final int MaxVolumeLevel = 10; 
	private static final int MinVolumeLevel = 1; 
	
	private String name; 
	private boolean powerOn;
	private int volumeLevel; 
	
	private Narrator narrator; 
	
	public Radio(String name) {
		// 
		this.name = name; 
		this.powerOn = false; 
		this.volumeLevel = MinVolumeLevel; 
		
		this.narrator = new Narrator(this, TalkingAt.Right); 
	}

	@Override
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
		if (volumeLevel < MaxVolumeLevel) {
			narrator.say("소리를 높입니다."); 
			volumeLevel++; 
			broadcasting();
		}
	}
	
	public void turnVolumeDown() {
		// 
		if (volumeLevel > MinVolumeLevel) {
			narrator.say("소리를 낮춥니다."); 
			volumeLevel--; 
			broadcasting();
		}
	}
	
	public int getVolumeLevel() {
		return volumeLevel; 
	}
	
	private void broadcasting() {
		//
		narrator.say("[볼륨:" + volumeLevel + "] 아, 아, 오늘의 뉴스를 말씀드리겠습니다."); 
	}
}