/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step1;

public class TimesTable {
	//
	public static void main(String[] args) {
		//
		TimesTable table = new TimesTable(); 
		table.showTable(); 
	}
	
	public TimesTable() {
		// 
	}
	
	public void showTable() {  
		//
		System.out.println("Let's print out the multiplication tables."); 
		System.out.println("------------------");  
		
		for (int leftNumber = 2; leftNumber<=9; leftNumber++) {
			for (int rightNumber = 1; rightNumber <=9; rightNumber++) {
				System.out.println(
						String.format(" %2d times %d = %2d ", 
								leftNumber, 
								rightNumber, 
								(leftNumber*rightNumber))); 
			}
			
			System.out.println("------------------"); 
		}
	}
}