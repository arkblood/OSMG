/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

import java.util.ArrayList;
import java.util.List;

public class TimesTableStory4 {
	//
	public static void main(String[] args) {
		//
		showLineTableAscendingDemo();
		showTimesTableObjectDemo();
		showLineTableDescendingDemo();
		showTimesTableProcedureDemo();
	}

	private static void showLineTableAscendingDemo() {
		//
		TimesTable timesTable = new TimesTable(ViewType.LineView); 
		timesTable.createDefaultViewTabels(); 
		timesTable.setSortOrder(SortOrder.Ascending);
		timesTable.show(); 
	}

	private static void showTimesTableObjectDemo() {
		//
		TimesTable timesTable = new TimesTable(ViewType.BoxView); 
		
		// User defined tables
		timesTable.addTable(new BoxViewTable(3, DisplayStyle.InKorean)); 
		timesTable.addTable(new BoxViewTable(5, DisplayStyle.InEnglish)); 
		timesTable.addTable(new BoxViewTable(7, DisplayStyle.InExpression)); 
		timesTable.addTable(new BoxViewTable(9));
		
		timesTable.setColumn(3);
		timesTable.show(); 
		timesTable.clearTables(); 

		// Default times tables
		timesTable.createDefaultViewTabels();
		timesTable.setColumn(5);
		timesTable.show(); 
	}

	private static void showTimesTableProcedureDemo() {
		//
		List<ViewTable> timesTables = new ArrayList<ViewTable>(); 
		timesTables.add(new BoxViewTable(3, DisplayStyle.InKorean)); 
		timesTables.add(new BoxViewTable(5, DisplayStyle.InEnglish)); 
		timesTables.add(new BoxViewTable(7, DisplayStyle.InExpression)); 
		timesTables.add(new BoxViewTable(9));
		
		BoxAligner boxAligner = new BoxAligner(); 
		boxAligner.setColumnCount(3);
		boxAligner.show((List<ViewTable>)timesTables);
		
		timesTables.clear(); 
		for(int leftNumber = 2; leftNumber <= 9; leftNumber++) {
			timesTables.add(new BoxViewTable(leftNumber, DisplayStyle.InKorean)); 
		}
		
		boxAligner.setColumnCount(5);
		boxAligner.show(timesTables);
	}
	
	private static void showLineTableDescendingDemo() {
		//
		TimesTable timesTable = new TimesTable(ViewType.LineView); 
		timesTable.createDefaultViewTabels();
		
		// timesTable.setColumn(5); do nothing
		timesTable.setSortOrder(SortOrder.Descending);
		timesTable.show(); 
	}
} 