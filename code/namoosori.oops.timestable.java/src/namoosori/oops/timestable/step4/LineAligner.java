/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

import java.util.Collections;
import java.util.List;

public class LineAligner implements Aligner {
	//
	private SortOrder sortOrder;  
	private int columnCount; 
	
	public LineAligner() {
		//
		this.columnCount = 1; 
		this.sortOrder = SortOrder.Descending; 
	}
	
	@Override
	public void setSortOrder(SortOrder sortOrder) {
		// 
		this.sortOrder = sortOrder; 
	}
	
	@Override
	public SortOrder getSortOrder() {
		return sortOrder; 
	}
	
	@Override
	public void setColumnCount(int columnCount) {
		// do nothing
		if (columnCount != 1) {
			System.out.println("Column count should be 1, doing nothing"); 
		}
	}
	
	@Override
	public int getColumnCount() {
		return columnCount; 
	}
	
	@Override
	public void show(List<ViewTable> sourceTables) {
		//
		@SuppressWarnings("unchecked")
		List<LineViewTable> lineViewTables = (List<LineViewTable>)(List<?>) sourceTables;
		
		List<LineViewTable> sortedLineViewTables = sortOrder(lineViewTables); 
		
		System.out.println("");

		for(LineViewTable lineTable : sortedLineViewTables) {
			lineTable.show();
			System.out.println("");
		}
	}
	
	public List<LineViewTable> sortOrder(List<LineViewTable> sourceTables) {
		// 
		switch(this.sortOrder) {
		case Ascending: 
			Collections.sort(sourceTables); 
			break; 
		case Descending: 
			Collections.sort(sourceTables, Collections.reverseOrder()); 
		}
		
		return sourceTables; 
	}

}