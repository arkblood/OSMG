/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

public class LineViewTable implements Comparable<LineViewTable>, ViewTable {
	//
	private int leftNumber;
	private Multiplier multiplier; 
	
	public LineViewTable(int leftNumber) {
		// 
		this.leftNumber = leftNumber;
		this.multiplier = new Multiplier(); 
	}

	@Override
	public int compareTo(LineViewTable tableTarget) {
		return this.getLeftNumber() - tableTarget.getLeftNumber();
	}

	@Override
	public int getLeftNumber() {
		return leftNumber; 
	}
	
	@Override
	public void show() {
		// 
		for (int right=1; right<=9; right++) {
			System.out.print(getColumn(right)); 
		}
	}
	
	@Override
	public void setFormat(DisplayStyle style) {
		// do nothing;  
	}

	public String getColumn(int rightNumber) {
		//
		return String.format("%2d ", multiplier.multiply(leftNumber, rightNumber));
	}
	
	public int multiply(int rightNumber) {
		// 
		return multiplier.multiply(leftNumber, rightNumber); 
	}
}