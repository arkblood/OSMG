/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step3;

public class BoxTable {
	//
	private int leftNumber;
	private DisplayStyle style; 
	private Multiplier multiplier; 
	
	public BoxTable(int leftNumber) {
		// 
		this.leftNumber = leftNumber;
		this.multiplier = new Multiplier(); 
		this.style = DisplayStyle.InEnglish; 
	}
	
	public BoxTable(int leftNumber, DisplayStyle style) {
		// 
		this(leftNumber); 
		setFormat(style); 
	}

	public void setFormat(DisplayStyle style) {
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
		return String.format(style.format(), leftNumber, rightNumber, multiply(rightNumber));
	}
	
	private int multiply(int rightNumber) {
		// 
		return multiplier.multiply(leftNumber,rightNumber); 
	}
}