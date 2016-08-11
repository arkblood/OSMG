/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

public class BoxViewTable implements ViewTable {
	//
	private int leftNumber;
	private DisplayStyle style; 
	private Multiplier multiplier; 
	
	public BoxViewTable(int leftNumber) {
		// 
		this.leftNumber = leftNumber;
		this.multiplier = new Multiplier(); 
		this.style = DisplayStyle.InEnglish; 
	}

	public BoxViewTable(int leftNumber, DisplayStyle style) {
		// 
		this(leftNumber); 
		setFormat(style); 
	}

	@Override
	public int getLeftNumber() {
		return leftNumber; 
	}
	
	@Override
	public void show() {
		// 
		for (int right=0; right<=9; right++) {
			System.out.println(getLine(right)); 
		}
	}
	
	@Override
	public void setFormat(DisplayStyle style) {
		// 
		this.style = style; 
	}

	public String getLine(int rightNumber) {
		//
		return String.format(style.format(), leftNumber, rightNumber, multiply(rightNumber));
	}
	
	private int multiply(int rightNumber) {
		// 
		return multiplier.multiply(leftNumber,rightNumber); 
	}
}