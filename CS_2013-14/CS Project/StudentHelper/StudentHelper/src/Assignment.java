//One assignment

public class Assignment {

	//one for each Assignment object
	private double score; //Assignment grade
	private String desc; //Assignment description
	
	//constructor
	public Assignment(String d, double s){
		desc = d; 
		score = s; 
	}
	//returns score:	
	public double getScore(){
		return score; 
	}
	
	//toString	
	public String toString(){
		return desc + ": " + score; 
	}
	//edit name of assignment
	public void changeName(String s)
	{
		desc = s; 
	}
	//edit score of assignment 
	public void changeScore(double s)
	{
		score = s; 
	}

}
