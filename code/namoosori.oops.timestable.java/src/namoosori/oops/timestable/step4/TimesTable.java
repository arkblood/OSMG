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

public class TimesTable {
	//
	private ViewType viewType; 
	private List<ViewTable> tables; 
	private Aligner aligner; 
	
	public TimesTable(ViewType viewType) {
		// 
		this.viewType = viewType; 
		this.tables = new ArrayList<ViewTable>();
		switch(viewType) {
		case BoxView: 
			this.aligner = new BoxAligner();
			break;
		case LineView: 
			this.aligner = new LineAligner();
		}
	}
	
	public void clearTables() {
		// 
		tables.clear(); 
	}
	
	public void createDefaultViewTabels() {
		// 
		this.clearTables(); 
		switch(viewType) {
		case BoxView: 
			for(int leftNumber = 2; leftNumber <= 9; leftNumber++) {
				addTable(new BoxViewTable(leftNumber, DisplayStyle.InKorean)); 
			}
			break; 
		case LineView: 
			for(int leftNumber = 2; leftNumber <= 9; leftNumber++) {
				addTable(new LineViewTable(leftNumber)); 
			}
			
			break; 
		}
	}
	
	public void addTable(ViewTable table) {
		// 
		this.tables.add(table); 
	}
	
	public void setColumn(int columnCount) {
		// 
		this.aligner.setColumnCount(columnCount); 
	}
	
	public void setSortOrder(SortOrder sortOrder) {
		// 
		this.aligner.setSortOrder(sortOrder); 
	}
	
	public void show() {
		// 
		this.aligner.show(tables); 
	}
}