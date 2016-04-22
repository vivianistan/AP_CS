//keeps tracks of subjects/classes, should give gpa from all subject scores
import java.util.ArrayList; 

public class ClassList {
private ArrayList<Subject> subList; 
private String name; 
private double gpa; 

//constructor
public ClassList (String n)
{
	name = n; 
	subList = new ArrayList<Subject>();
}

//add subject, already made
public void addSubject(Subject sub)
{
	subList.add(sub);
	
}
//get total gpa
public double getTotalGpa()
{
	double temp = 0; 
	for(int x=0; x<subList.size(); x++)
	{
		temp+=subList.get(x).toGpa();
	}
	gpa = temp/(subList.size());
	return gpa;
}

//toString
public String toString()
{
	String temp = ""; 
	for(int x = 0; x<subList.size(); x++)
	{
		temp+= subList.get(x).toString() + "\n";
	}
	return temp; 
}

//return name of class list
public String getName()
{
	return name; 
}

//returns subList
public ArrayList<Subject> getList()
{
	return subList; 
}

//returns subject string in certain place
public String getSubjectString(int place)
{
	return subList.get(place).toString(); 
}
//returns subject in a certain place
public Subject getSubject(int place){  
	return subList.get(place); 
}
//returns size of class list 
public int size()
{	
	return subList.size();
}

}
