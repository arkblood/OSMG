/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step31;

public class TimesTableStory31 {
	//
	public static void main(String[] args) {
		//
		showBoxTableWithObjectDemo();
	}

	private static void showBoxTableWithObjectDemo() {
		//
		TimesTable timesTable = new TimesTable(); 
		
		timesTable.addTable(new UnitTable(3, ExpressionStyle.InKorean)); 
		timesTable.addTable(new UnitTable(5, ExpressionStyle.InEnglish)); 
		timesTable.addTable(new UnitTable(7, ExpressionStyle.InMath)); 
		timesTable.addTable(new UnitTable(9, ExpressionStyle.InCoding));
		
		timesTable.setColumn(5);
		timesTable.show(); 
		
		timesTable.clear(); 
		timesTable.setExpressionStyle(ExpressionStyle.InMath); 
		timesTable.createDefaultUnitTables(); 
		timesTable.setColumn(2);
		timesTable.show(); 
	}
} 