package GameCode;

public class Domino {
	private int side1;
	private int side2;

	Domino(int s1, int s2){
		this.side1 = s1;
		this.side2 = s2;
	}
	
	int getSide1(){
		return this.side1;
	}
	
	int getSide2(){
		return this.side2;
	}
	
	//function which returns the sum of the two sides of the domino
	public int getSum(){
		return this.side2+this.side1;
	}
	
	public Integer getSum2(){
		return this.side2+this.side1;
	}
	
	//function determines whether a domino is a double
	public boolean isDouble()
	{
		return getSide1() == getSide2();
	}

	@Override
	public String toString() {
		return side1 + "||" + side2;
	}

	boolean equals(Domino domino) {
		return ((side1 == domino.side1) && (side2 == domino.side2)) ||
			((side1 == domino.side2) && (side2 == domino.side1));
	}
}
