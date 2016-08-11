/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step33;

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
	
	public static void main(String[] args) {
		//
		TimesTable timesTable = new TimesTable(); 
		
		int columnCount = 5; 
		timesTable.addItemFormat(4, FormatType.InKorean); 
		timesTable.addItemFormat(2, FormatType.InExpression); 
		
		System.out.println("Let's print out the multiplication tables."); 
		System.out.println("-----------------"); 
		timesTable.showTable(columnCount); 
		System.out.println("-----------------"); 
	}
	
	public TimesTable() {
		// 
		this.defaultItemFormat = ItemFormatInEnglish; 
		this.itemFormatMap = new HashMap<Integer,String>(); 
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
	
	public void showTable(int columnCount) {
		// 
		if (columnCount > MaxTimes) {
			throw new RuntimeException(
					String.format("The column count should be less than %d, but it's %d. --> ", MaxTimes, columnCount)); 
		}
		
		int leftNumber = 2; 
		while(true) {
			for (int rightNumber = 1; rightNumber <=MaxTimes; rightNumber++) {
				for(int offset=0; offset<columnCount; offset++) {
					if (leftNumber+offset > MaxTimes) {
						break; 
					}
					System.out.print(buildTimesItem(leftNumber+offset, rightNumber));
					System.out.print("  "); 
				}
				System.out.println("  "); 
			}
			System.out.println(" "); 
			
			leftNumber += columnCount; 
			if (leftNumber > MaxTimes) {
				break; 
			}
		}
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
		BoxView, 
		LineView
	}
}