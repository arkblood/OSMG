/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step2;

public class TimesTable {
	//
	public static void main(String[] args) {
		//
		TimesTable timesTable = new TimesTable(); 
		
		timesTable.showTable(); 
	}
	
	public TimesTable() {
		// 
	}
	
	public void showTable() {
		// 
		System.out.println("Let's print out the multiplication tables."); 
		System.out.println("-----------------"); 
		
		String itemFormat = " %d times %d = %2d "; 
		
		for (int leftNumber = 2; leftNumber<=9; leftNumber++) {
			for (int rightNumber = 1; rightNumber <=9; rightNumber++) {
				System.out.println(buildTimesItem(itemFormat, leftNumber, rightNumber)); 
			}
			System.out.println("-----------------"); 
		}
	}
	
	public String buildTimesItem(String itemFormat, int leftNumber, int rightNumber) {
		//
		return String.format(itemFormat, 
				leftNumber,
				rightNumber,
				multiply(leftNumber, rightNumber)); 
	}
	
	public static int multiply(int left, int right) {
		// 
		return left * right; 
	}
}