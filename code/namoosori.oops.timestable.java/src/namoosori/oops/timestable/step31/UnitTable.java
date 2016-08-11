/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step31;

import java.util.HashMap;
import java.util.Map;

public class UnitTable {
	//
	private int leftNumber;
	private ExpressionStyle style; 
	private Map<Integer,UnitExpression> unitExpressions; 
	
	public UnitTable(int leftNumber) {
		// 
		this.leftNumber = leftNumber;
		this.unitExpressions = new HashMap<>();  
		this.style = ExpressionStyle.InEnglish; 
		this.initUnitExpression(); 
	}
	
	public UnitTable(int leftNumber, ExpressionStyle style) {
		// 
		this(leftNumber); 
		setStyle(style); 
	}

	private void initUnitExpression() {
		// 
		for (int rightNumber = 1; rightNumber <= 9; rightNumber++) {
			unitExpressions.put(rightNumber, new UnitExpression(leftNumber, rightNumber)); 
		}
	}
	
	public int getLeftNumber() {
		return leftNumber; 
	}
	
	public void setStyle(ExpressionStyle style) {
		// 
		this.style = style; 
	}
	
	public void show() {
		// 
		for (int right=0; right<=9; right++) {
			System.out.println(getFormattedLine(right)); 
		}
	}
	
	public String getFormattedLine(int rightNumber) {
		//
		UnitExpression expression = unitExpressions.get(rightNumber); 
		
		return String.format(style.format(), 
				expression.getLeftNumber(), 
				expression.getRightNumber(), 
				expression.getResultValue());
	}
}