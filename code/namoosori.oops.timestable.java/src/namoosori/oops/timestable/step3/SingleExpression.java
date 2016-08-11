package namoosori.oops.timestable.step3;

public class SingleExpression {
	//
	private int leftNumber; 
	private int rightNumber; 
	private int resultValue; 
	
	public SingleExpression(int left, int right) {
		// 
		this.leftNumber = left; 
		this.rightNumber = right; 
		this.resultValue = left * right; 
	}

	public int getLeftNumber() {
		return leftNumber;
	}

	public void setLeftNumber(int leftNumber) {
		this.leftNumber = leftNumber;
	}

	public int getRightNumber() {
		return rightNumber;
	}

	public void setRightNumber(int rightNumber) {
		this.rightNumber = rightNumber;
	}

	public int getResultValue() {
		return resultValue;
	}

	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
}
