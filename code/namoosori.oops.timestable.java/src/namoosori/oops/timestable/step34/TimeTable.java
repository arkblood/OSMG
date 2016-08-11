package namoosori.oops.timestable.step34;

public class TimeTable {
	//
	public static void main(String[] args) {
		// 
		printTimesTable(8); 
	}
	
	private static void printTimesTable(int columnCount) {
		// 
		int loopCount = (8 / columnCount) + 1; 
		
		int leftNumberOffset = 2; 
		for(int i=0; i<loopCount; i++) {
			for(int rightNumber=1; rightNumber<=9; rightNumber++) {
				for(int count = 0; count < columnCount; count++) {
					int leftNumber = leftNumberOffset + count; 
					if (leftNumber > 9) {
						break; 
					}
					printUnit(leftNumber, rightNumber); 
				}
				System.out.println("");
 			}
			leftNumberOffset += columnCount; 
			System.out.println(""); 
		}
	}
	
	private static void printUnit(int leftNumber, int rightNumber) {
		System.out.print("\t" + leftNumber + " * " + rightNumber + " = " + (leftNumber*rightNumber));
	}
}
