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

public class BoxAligner {
	//
	private static final int DefaultColumnCount = 3; 
	private static final int DefaultTableLength = 18; 
	
	private int columnCount; 
	
	public BoxAligner() {
		//
		this.columnCount = DefaultColumnCount; 
	}

	public void setColumn(int column) {
		// 
		this.columnCount = column; 
	}
	
	public void show(List<BoxTable> tables) {
		//
		List<BoxTable> lineTables = new ArrayList<BoxTable>(); 
		
		for (BoxTable table : tables) {
			lineTables.add(table); 
			if (lineTables.size() == columnCount) {
				showLineTables(lineTables);
				lineTables.clear();
			}
		}
		
		if (lineTables.size() > 0) {
			showLineTables(lineTables); 
		}
	}
	
	private void showLineTables(List<BoxTable> tables) {
		//
		int tableSize = tables.size();
		int lineLength = 0; 
		
		for (int right = 1; right<=9; right++) {
			StringBuilder builder = new StringBuilder(); 
			for (int i=0; i<tableSize; i++) {
				String line = tables.get(i).getFormattedLine(right); 
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
