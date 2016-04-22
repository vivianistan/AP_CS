import java.util.Scanner;

public class TestStudent {

	private static Scanner scanString;
	private static Scanner scanDouble;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		scanString = new Scanner(System.in);
		scanDouble = new Scanner(System.in);
		
Assignment csProject = new Assignment("CS Project", 100);

Subject compSci = new Subject("Computer Science"); 

compSci.addAssignment(csProject); 
compSci.addAssignment("Lab00", 95);
compSci.addAssignment("Lab01", 98);

ClassList list = new ClassList("Semester1"); 
list.addSubject(compSci);

//System.out.println("GPA  " + compSci.toGpa());

//test loop, adding assignments
int count = 0; 
while (count <=0 ){
	 
	System.out.println("Add an assignment to Computer Science? (y/n)");
	String answer = scanString.nextLine();
	count++; 
	if(answer.compareTo("n") != 0)
	{
		System.out.println("Name of assignment?");
		String name = scanString.nextLine();
		System.out.println("Score?");
		double num = scanDouble.nextDouble();
		compSci.addAssignment(name, num);
		answer = ""; 
		count--; 
	}

} 

//test loop, adding subjects/classes, better
count = 0; 
while(count <=0){
	
	System.out.println("Add a subject to " + list.getName() +"? (y/n)"); 
	String answer = scanString.nextLine();
	count++; 
	
	if(answer.compareTo("n") != 0){
		System.out.println("Name of subject?"); 
		String name = scanString.nextLine();
		Subject sub = new Subject(name); 
		list.addSubject(sub);
		
		int c2 = 0;
		
		while(c2<=0){
		System.out.println("Add an assignment to " + sub.getName() + "? (y/n)");  
		String ans = scanString.nextLine();
		c2++; 
		if(ans.compareTo("n") != 0)
		{
			System.out.println("Name of assignment?");
			String name2 = scanString.nextLine();
			System.out.println("Score?");
			double num = scanDouble.nextDouble();
			sub.addAssignment(name2, num);
			ans = ""; 
			c2--; 
		}
		
		}
		count--; 		
	}
}

System.out.println(compSci.getReport());

//note, only works well if all assignments are weighed equally


//System.out.println(csProject); 

//System.out.println(compSci);

//Loop to print stuff, same as toString? 
double g = list.getTotalGpa(); 

System.out.println("GPA:"+ g); 

for(int k = 0; k<list.getList().size(); k++)
{
System.out.println(list.getSubjectString(k+1)); 
}

//System.out.println(list); 



	}

}
