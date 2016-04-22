//Contains assignments, has an overall grade
import java.util.ArrayList;

public class Subject {
//one class or subject, contains assignments.
	
	private String courseName; //name of subject
	private ArrayList<Assignment> assignList; //list of assignments
	private double totalScore; //total assignment scores
	private double avgScore; //overall grade
	
	//constructor
	public Subject (String cN)
	{
		courseName = cN; 
		assignList = new ArrayList<Assignment>();
		totalScore = 0; 
	}
	
	//add assignments
	public void addAssignment(String name, double score){
		Assignment a = new Assignment(name, score); 
		assignList.add(a);
		totalScore += a.getScore(); 
	}
	
	//overloaded, add an already made assignment
	public void addAssignment(Assignment a){
		assignList.add(a);
		totalScore +=  a.getScore(); 
	} 
	
	//get and calculate total score	
	public double getAvg()
	{
	avgScore = totalScore/assignList.size();
	return avgScore;
	}
	
	//returns course name
	public String getName()
	{
		return courseName; 
	}
	
	//toString
	public String toString(){
		return courseName + ": \t" + getAvg(); 
	}
	
	//returns complete report	
	public String getReport(){
		
		String list = ""; 
		list+=  courseName + " Grade: " + getAvg() +" \n";
		for(int x = 0; x<assignList.size(); x++)
		{
			list+=(assignList.get(x).toString()) + "\n ";
		}
		return list; 
	}
	
	//convert to gpa
	public double toGpa(){
		this.getAvg();
		if(avgScore>=90)
		{
			return 4.0; 
		}
		else if(avgScore>=80){
			return 3.0; 
		}
		else if(avgScore>=70){
			return 2.0; 
		}
		else if(avgScore>=60){
			return 60; 
		}
		else
			return 0; 
	}
	//edit name of subject
	public void changeName(String s)
	{
		courseName = s; 
	}
	//edit name of assignment in list 
	public void changeAssignmentName(int place, String s)
	{
		assignList.get(place+1).changeName(s); 
	}
	//edit score of assignment in list 
	public void changeAssignmentScore(int place, double s)
	{
		assignList.get(place+1).changeScore(s); 
	}
}
