/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step44;

import java.util.HashMap;
import java.util.Map;

public class TimesTable {
	//
	private static final String ItemFormatInEnglish = " %d times %d = %2d "; 
	private static final String ItemFormatInExpression = " %d X %d = %2d "; 
	private static final String ItemFormatInKorean = " %d 곱하기 %d 는 %2d ";
	private static final int MaxTimes = 9; 
	
	private Map<Integer,String> itemFormatMap; 
	private String defaultItemFormat;
	private ViewType viewType;
	private int columnCount;
	
	public static void main(String[] args) {
		//
		TimesTable timesTable = new TimesTable(ViewType.LineView);
		System.out.println("-------- showLineTableAscendingDemo --------");
		timesTable.showTable(SortOrder.Ascending); 
		timesTable.showTable(SortOrder.Descending); 

		timesTable = new TimesTable(ViewType.BoxView);
		
		timesTable.addItemFormat(4, FormatType.InKorean); 
		timesTable.addItemFormat(2, FormatType.InExpression);
		timesTable.setColumnCount(5);
		
		System.out.println("--------- showTimesTableObjectDemo ---------"); 
		timesTable.showTable(SortOrder.Ascending);
		System.out.println("--------------------------------------------");
		timesTable.showTable(SortOrder.Descending);
	}
	
	public TimesTable(ViewType viewType) {
		// 
		this.defaultItemFormat = ItemFormatInEnglish; 
		this.itemFormatMap = new HashMap<Integer,String>(); 
		this.viewType = viewType;
		this.columnCount = 9;
	}
	
	private void showTable(SortOrder sortOrder) {
		//
		switch(viewType) {
		case BoxView: 
			showBoxTable(sortOrder);
			break;
		case LineView: 
			showLineTable(sortOrder);
		}
	}
	
	public void showBoxTable(SortOrder sortOrder) {
		// 
		if (columnCount > MaxTimes) {
			throw new RuntimeException(
					String.format("The column count should be less than %d, but it's %d. --> ", MaxTimes, columnCount)); 
		}
		
		int leftNumber = 2;
		
		if(SortOrder.Descending.equals(sortOrder)) {
			leftNumber = MaxTimes;
		}
		
		System.out.println();
		
		while(true) {
			for (int rightNumber = 1; rightNumber <=MaxTimes; rightNumber++) {
				for(int offset=0; offset<columnCount; offset++) {
					int newLeftNumber = leftNumber + offset;
					if(SortOrder.Descending.equals(sortOrder)) {
						newLeftNumber = leftNumber - offset;
					}
					if (newLeftNumber < 2 || newLeftNumber > MaxTimes) {
						break; 
					}
					System.out.print(buildTimesItem(newLeftNumber, rightNumber));
					System.out.print("  ");
				}
				System.out.println(); 
			}
			System.out.println(); 
			
			if(SortOrder.Ascending.equals(sortOrder)) {
				leftNumber += columnCount;
			} else {
				leftNumber -= columnCount;
			}
			if (leftNumber < 2 || leftNumber > MaxTimes) {
				break; 
			}
		}
	}
	
	public void showLineTable(SortOrder sortOrder) {
		//
		int leftNumber = 2;
		int addNumber = 1;
		
		if(SortOrder.Descending.equals(sortOrder)) {
			leftNumber = MaxTimes;
			addNumber = -1;
		}
		
		System.out.println();
		
		while(true) {
			for(int rightNumber = 1; rightNumber <= MaxTimes; rightNumber++) {
				System.out.print(getColumn(leftNumber, rightNumber));
			}
			
			System.out.println();
			
			leftNumber += addNumber;
			if(leftNumber < 2 || leftNumber > MaxTimes) {
				break;
			}
		}
		System.out.println();
	}
	
	public String getColumn(int leftNumber, int rightNumber) {
		//
		return String.format("%2d ", multiply(leftNumber, rightNumber));
	}

	public void addItemFormat(int leftNumber, FormatType formatType) {
		// 
		itemFormatMap.put(leftNumber, formatType.getKrName()); 
	}
	
	public String getItemFormatStr(int leftNumber) {
		// 
		String itemFormatStr = itemFormatMap.get(leftNumber);
		
		if (itemFormatStr == null) {
			itemFormatStr = this.defaultItemFormat; 
		}
		
		return itemFormatStr; 
	}
	
	public String buildTimesItem(int leftNumber, int rightNumber) {
		//
		String itemFormat = this.getItemFormatStr(leftNumber); 
		
		return String.format(itemFormat, 
				leftNumber,
				rightNumber,
				multiply(leftNumber, rightNumber)); 
	}
	
	public static int multiply(int left, int right) {
		// 
		return left * right; 
	}
	
	enum FormatType {
		// 
		InEnglish(ItemFormatInEnglish), 
		InExpression(ItemFormatInExpression), 
		InKorean(ItemFormatInKorean); 
		
		private String krName; 
		
		private FormatType(String krName) {
			this.krName = krName; 
		}
		
		public String getKrName() {
			return krName; 
		}
	}
	
	enum ViewType {
		//
		BoxView, 
		LineView
	}
	
	enum SortOrder {
		//
		Ascending, 
		Descending,
	}
	
	private void setColumnCount(int columnCount) {
		//
		this.columnCount = columnCount;
	}
}