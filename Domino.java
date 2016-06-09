package GameFiles;

public class Domino {
	private int side1;
	private int side2;

	public Domino(int s1, int s2){
		this.side1 = s1;
		this.side2 = s2;
	}
	
	public int getSide1(){
		return this.side1;
	}
	
	public int getSide2(){
		return this.side2;
	}
	
	//function which determines whether a domino is a double
	//returns true if it is a double, false otherwise 
	public boolean isDouble()
	{
		return this.getSide1() == this.getSide2();
	}
	
	//make a function that just returns what that double is of
	public int doubleIsOf()
	{
		if (this.isDouble()){
			return this.getSide1();
		}
		else{
			return 7;
		}
	}
}
