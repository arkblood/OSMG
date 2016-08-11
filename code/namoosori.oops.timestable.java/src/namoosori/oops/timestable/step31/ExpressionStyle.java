/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step31;

public enum ExpressionStyle {
	//
	InKorean("%d 곱하기 %2d 는 %2d"), 
	InEnglish("%d times %2d is %2d"), 
	InMath("%d x %2d = %2d"),
	InCoding("%d * %2d = %2d");
	
	private String format; 
	
	private ExpressionStyle(String format) {
		//
		this.format = format; 
	}
	
	public String format() {
		//
		return format; 
	}
}