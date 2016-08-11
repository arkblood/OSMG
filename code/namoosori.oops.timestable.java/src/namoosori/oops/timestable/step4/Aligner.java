/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

import java.util.List;

public interface Aligner {
	//
	public void setColumnCount(int columnCount); 
	public int getColumnCount(); 
	public void setSortOrder(SortOrder sortOrder); 
	public SortOrder getSortOrder(); 
	public void show(List<ViewTable> sourceTables); 
}