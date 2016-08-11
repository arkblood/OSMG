/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

public enum DisplayStyle {
	//
	InKorean("%d 곱하기 %d 는 %d"), 
	InEnglish("%d times %d is %d"), 
	InExpression("%d x %d = %d");
	
	private String format; 
	
	private DisplayStyle(String format) {
		//
		this.format = format; 
	}
	
	public String format() {
		//
		return format; 
	}
}