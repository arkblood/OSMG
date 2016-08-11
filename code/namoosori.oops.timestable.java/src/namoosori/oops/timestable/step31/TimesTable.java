/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step31;

import java.util.ArrayList;
import java.util.List;

public class TimesTable {
	//
	private ExpressionStyle expressionStyle; 
	private List<UnitTable> unitTables; 
	private UnitTableAligner unitTableAligner; 
	
	public TimesTable() {
		// 
		this.expressionStyle = ExpressionStyle.InEnglish; 
		this.unitTables = new ArrayList<UnitTable>();
		this.unitTableAligner = new UnitTableAligner(); 
	}
	
	public void clear() {
		// 
		this.unitTables.clear(); 
	}
	
	public void setExpressionStyle(ExpressionStyle expressionStyle) {
		// 
		this.expressionStyle = expressionStyle;
	}
	 
	public void createDefaultUnitTables() {
		// 
		for(int leftNumber = 2; leftNumber <= 9; leftNumber++) {
			// 
			addTable(new UnitTable(leftNumber, expressionStyle)); 
		}
	}
	
	public void clearUnitTable() {
		// 
		unitTables.clear(); 
	}
	
	public void addTable(UnitTable table) {
		// 
		unitTables.add(table); 
	}
	
	public void setColumn(int columnCount) {
		// 
		unitTableAligner.setColumn(columnCount); 
	}
	
	public void show() {
		// 
		unitTableAligner.show(unitTables); 
	}
}