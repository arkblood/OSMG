/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.ui;

import java.util.Scanner;

import namoosori.oops.radio.step4.stage.Director;

public class RadioCli {
	//
	private Director director; 
	private Scanner scanner; 
	
	public RadioCli() {
		// 
		this.director = new Director(); 
		this.scanner = new Scanner(System.in);
	}
	
	public void showMenuAndAction() {
		//
		while (true) {
			System.out.println();
			System.out.println("..............................");
			System.out.println(" 일하면서 라디오 듣기 메뉴");
			System.out.println("..............................");
			System.out.println(" 0. Program exit");
			System.out.println(" 1. 라디오 켜기");
			System.out.println(" 2. 라디오 소리 조정");
			System.out.println("..............................");

			int inputNumber = acceptMenuItem("Select number");
			
			switch (inputNumber) {
			// 
			case 1:
				turnOnTheRadio();
				break;
			case 2:
				adjustTheVolume();
				break;
			case 0:
				exitProgram(); 
				return;
				
			default:
				System.out.println("Choose again!");
			}
		}
	}

    public int acceptMenuItem(String message) {
        //
        System.out.print(message + ": ");
        String inputText = scanner.nextLine();
        
        try {
            return Integer.valueOf(inputText);
        } catch (NumberFormatException e) {
            System.out.println("값을 잘못 입력했습니다. 숫자만 입력하세요.");
            return 999;
        }
    }

	public void turnOnTheRadio() {
		// 
		director.playTurnOnRadioScene();
	}
	
	public void adjustTheVolume() {
		// 
		director.playAdjustVolumeScene();
	}
	 
	public void exitProgram() {
		// 
		System.out.println("Program exit");
	}
}