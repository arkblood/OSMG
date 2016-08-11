/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step3;

import java.util.ArrayList;
import java.util.List;

public class TimesTable {
	//
	private List<BoxTable> tables; 
	private BoxAligner boxAligner; 
	
	public TimesTable() {
		// 
		this.tables = new ArrayList<BoxTable>();
		this.boxAligner = new BoxAligner(); 
	}
	
	public void clear() {
		// 
		this.tables.clear(); 
	}
	
	public void addTable(BoxTable table) {
		// 
		this.tables.add(table); 
	}
	
	public void setColumn(int columnCount) {
		// 
		this.boxAligner.setColumn(columnCount); 
	}
	
	public void show() {
		// 
		this.boxAligner.show(tables); 
	}
}