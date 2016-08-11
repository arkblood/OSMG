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

public class BoxAligner implements Aligner {
	//
	private static final int DefaultColumnCount = 3; 
	private static final int DefaultTableLength = 18; 
	
	private int columnCount; 
	private SortOrder sortOrder; 
	
	public BoxAligner() {
		//
		this.columnCount = DefaultColumnCount;
		this.sortOrder = SortOrder.Ascending; 
	}

	@Override
	public void setColumnCount(int columnCount) {
		// 
		this.columnCount = columnCount; 
	}
	
	@Override
	public int getColumnCount() {
		return columnCount; 
	}
	

	@Override
	public void setSortOrder(SortOrder sortOrder) {
		//
		this.sortOrder = sortOrder; 
	}

	@Override
	public SortOrder getSortOrder() {
		// 
		return sortOrder;
	}

	@Override
	public void show(List<ViewTable> sourceTables) {
		//
		@SuppressWarnings("unchecked")
		List<BoxViewTable> boxViewTables = (List<BoxViewTable>)(List<?>) sourceTables;
		List<BoxViewTable> lineTables = new ArrayList<BoxViewTable>(); 
		
		for (BoxViewTable table : boxViewTables) {
			lineTables.add(table); 
			if (lineTables.size() == columnCount) {
				showLineTables(lineTables);
				lineTables.clear();
			}
		}
		
		if (lineTables.size() > 0) {
			showLineTables(lineTables); 
			lineTables.clear();
		}
	}
	
	private void showLineTables(List<BoxViewTable> tables) {
		//
		int tableSize = tables.size();
		int lineLength = 0; 
		
		for (int right = 1; right<=9; right++) {
			StringBuilder builder = new StringBuilder(); 
			for (int i=0; i<tableSize; i++) {
				String line = tables.get(i).getLine(right); 
				builder.append(fillSpace(line, DefaultTableLength)); 
			}
			lineLength = builder.length(); 
			System.out.println(builder.toString()); 
		}
		
		System.out.println(fillDot(lineLength)); 
	}
	
	private String fillSpace(String str, int size) {
		// 
		char[] charArray = new char[size]; 
		for(int i=0; i<size; i++) {
			if(i>=str.length()) {
				charArray[i] = ' '; 
			} else {
				charArray[i] = str.charAt(i); 
			}
		}
		
		return String.valueOf(charArray); 
	}
	
	private String fillDot(int size) {
		// 
		char[] charArray = new char[size]; 
		for (int i=0; i<size; i++) {
			charArray[i] = '-'; 
		}
		
		return String.valueOf(charArray); 
	}

}
