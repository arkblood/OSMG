/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step3;

public class TimesTableStory3 {
	//
	public static void main(String[] args) {
		//
		showBoxTableWithObjectDemo();
		// showBoxTableWithProcedureDemo();
	}

	private static void showBoxTableWithObjectDemo() {
		//
		TimesTable timesTable = new TimesTable(); 
		
		timesTable.addTable(new BoxTable(3, DisplayStyle.InKorean)); 
		timesTable.addTable(new BoxTable(5, DisplayStyle.InEnglish)); 
		timesTable.addTable(new BoxTable(7, DisplayStyle.InExpression)); 
		timesTable.addTable(new BoxTable(9));
		
		timesTable.setColumn(3);
		timesTable.show(); 
		
		timesTable.clear(); 
		for(int leftNumber = 2; leftNumber <= 9; leftNumber++) {
			timesTable.addTable(new BoxTable(leftNumber, DisplayStyle.InKorean)); 
		}
		
		timesTable.setColumn(1);
		timesTable.show(); 
	}
} 