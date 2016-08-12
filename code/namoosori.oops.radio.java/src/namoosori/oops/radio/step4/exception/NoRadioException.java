/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.exception;

public class NoRadioException extends RuntimeException {
	//
	private static final long serialVersionUID = 7739884867884451421L;

	public NoRadioException() {
		// 
	}
	
	public NoRadioException(String message) {
		// 
		super(message); 
	}
}