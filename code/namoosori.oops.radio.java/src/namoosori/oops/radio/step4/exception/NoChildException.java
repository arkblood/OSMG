/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.radio.step4.exception;

public class NoChildException extends RuntimeException {
	//
	private static final long serialVersionUID = 5803920661574990365L;

	public NoChildException() {
		// 
	}
	
	public NoChildException(String message) {
		// 
		super(message); 
	}
}