import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;				//imports
import java.awt.event.ActionEvent;

import javax.swing.*;

public class StudentHelperGui {

	public static void main(String[] args) {
		
		final Font subjectFont = new Font("Arial", Font.PLAIN, 18); //font for subjects
		final String gpa, class1, class2, class3, class4,
		class5, class6, class7, class8; //gpa and class strings
		final JLabel nameLabel, gpaLabel, cLabel1, cLabel2, cLabel3, 
		cLabel4, cLabel5, cLabel6, cLabel7, cLabel8; //class labels
		final JTextField nameBox;  //text field for name
		
		//Assigning initial assignment and class to class list
		
		Assignment csProject = new Assignment("CS Project", 100); //initial assignment
		Subject compSci = new Subject("Computer Science"); //initial subject
		compSci.addAssignment(csProject); //adding subject to the CS Subject
		
		final ClassList list = new ClassList("Semester1"); //creating list of classes
		list.addSubject(compSci); //adding CS to the list of classes
		
		gpa = ""+ list.getTotalGpa(); //gets gpa from list of classes
		
		class1 = list.getSubjectString(0); //setting the string for the first class 
										   //label to the first subject in the list

		class2 = null; 
		class3 = null; 
		class4 = null; 
		class5 = null; 					//setting subject label strings to nothing
		class6 = null; 					//no subjects added yet
		class7 = null; 
		class8 = null; 
		
		//Creating frame for gui
		final JFrame frame = new JFrame(); 		
		frame.setTitle("StudentHelper");
		frame.setSize(700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Creating base Panel that all the other components go on		
		JPanel basePanel = new JPanel(new BorderLayout());
		
		//Top panel that has the student name and overall GPA 
		JPanel namePanel = new JPanel(new GridLayout());
		nameLabel = new JLabel("Your Name Here", JLabel.LEFT);  //name
		nameLabel.setFont(new Font("Arial", Font.BOLD, 20));		
		gpaLabel = new JLabel("GPA: " + gpa);					//gpa
		gpaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		nameBox = new JTextField("Enter Name");				//box for changing name
		JButton nameButton = new JButton("Set Name"); 
		nameButton.addActionListener(new ActionListener()	//button to change name
		{ 
			public void actionPerformed(ActionEvent e) 			
			{
				nameLabel.setText(nameBox.getText()); //gets box text and changes name the label
			}
		});		
		namePanel.add(nameLabel); 
		namePanel.add(gpaLabel);			//add components to namePanel
		namePanel.add(nameBox);
		namePanel.add(nameButton);
		basePanel.add(namePanel,BorderLayout.NORTH);   //add namePanel to basePanel in the North
		
		//West panel that contains the list of classes and scores for each one
		JPanel classPanel = new JPanel(new GridLayout(8,1));
		cLabel1 = new JLabel("C1 " + class1); 
		cLabel2 = new JLabel("C2 " + class2); 
		cLabel3 = new JLabel("C3 " + class3); 
		cLabel4 = new JLabel("C4 " + class4); 	//sets labels for each class to 
		cLabel5 = new JLabel("C5 " + class5);	//a letter and number 
		cLabel6 = new JLabel("C6 " + class6);	//and later to a class name
		cLabel7 = new JLabel("C7 " + class7); 
		cLabel8 = new JLabel("C8 " + class8);
		cLabel1.setFont(subjectFont);
		cLabel2.setFont(subjectFont);
		cLabel3.setFont(subjectFont); 
		cLabel4.setFont(subjectFont);				//changing font
		cLabel5.setFont(subjectFont);
		cLabel6.setFont(subjectFont);
		cLabel7.setFont(subjectFont); 
		cLabel8.setFont(subjectFont);
		classPanel.add(cLabel1); 
		classPanel.add(cLabel2);
		classPanel.add(cLabel3);
		classPanel.add(cLabel4);				//adding labels to the classPanel
		classPanel.add(cLabel5);
		classPanel.add(cLabel6);
		classPanel.add(cLabel7);
		classPanel.add(cLabel8);
		basePanel.add(classPanel, BorderLayout.WEST);	//adding classPanel to basePanel in the West
		
		//East panel that does things, changes the classPanel and namePanel
		JPanel doPanel = new JPanel(new GridLayout(7,2)); 
		String[] actionString = { "Add Assignment to C1","Add Assignment to C2",
				"Add Assignment to C3","Add Assignment to C4","Add Assignment to C5", //list of actions
				"Add Assignment to C6","Add Assignment to C7","Add Assignment to C8", 
		 		"Add Subject", "Change a Subject Name"};
		final JComboBox<String> actions = new JComboBox<String>(actionString);  //drop down box with list
		actions.setSelectedIndex(9); //number of actions shown (all)
		JLabel gradeLabel = new JLabel("Grade: ", JLabel.RIGHT); //label showing where to add grades
		gradeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		JLabel assignLabel = new JLabel("Subject/Assignment Name: ", JLabel.RIGHT); //label showing where to write subject/assignment name
		assignLabel.setFont(new Font("Arial", Font.PLAIN, 14)); 
		final JTextField assignGradeField = new JTextField("Grade Here");  //box for adding grades
		final JTextField assignNameField = new JTextField("Write Here"); //box for adding name of subject/assignment
		JButton doButton = new JButton("Enter"); 	//button that initiates the action chosen from the comboBox
		//button that does everything listed in comboBox
		doButton.addActionListener(new ActionListener()		
		{
			public void actionPerformed(ActionEvent e)
			{
			String answer = (String) actions.getSelectedItem(); 	//gets action from comboBox
			String nameText = assignNameField.getText();          //gets name of assignment/subject
			double gradeNum = 0; 				
			if(assignGradeField.getText().equals("Grade Here") != true)
			{
				gradeNum = Double.parseDouble(assignGradeField.getText());	//gets grade if written in box
			}			 
			if(answer.equals("Add Assignment to C1"))		//adds assignment to C1 if chosen
				{
				list.getSubject(0).addAssignment(nameText, gradeNum); //adds assignment to first subject in class list
				String temp = list.getSubjectString(0); 	//string for name of subject and its grade
				cLabel1.setText("C1 " + temp);			//changes C1 label
				}
			else if(answer.equals("Add Assignment to C2")) //adds assignment to C2 if chosen
				{
					if(list.size()<2)
						JOptionPane.showMessageDialog(frame, "Does not exist!");  //shows error if subject does not exist yet
				else{
				list.getSubject(1).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(1);
				cLabel2.setText("C2 " + temp);				//changes C2 label
				}
				}
			else if(answer.equals("Add Assignment to C3"))
				{
				if(list.size()<3)
					JOptionPane.showMessageDialog(frame, "Does not exist!");  //error if assignment DNE
				else{
				list.getSubject(2).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(2);
				cLabel3.setText("C3 " + temp); 			//changes C3 label
				}
				}
			else if(answer.equals("Add Assignment to C4"))
				{
				if(list.size()<4)
					JOptionPane.showMessageDialog(frame, "Does not exist!");	//error if assignment DNE
				else{
				list.getSubject(3).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(3);
				cLabel4.setText("C4 " + temp);						//changes C4 label
				}
				}
			else if(answer.equals("Add Assignment to C5"))
			{
				if(list.size()<5)
					JOptionPane.showMessageDialog(frame, "Does not exist!"); //error if assignment DNE
				else{
				list.getSubject(4).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(4); 
				cLabel5.setText("C5 " + temp);					//changes C5 label
			}
			}			
			else if(answer.equals("Add Assignment to C6"))
			{
				if(list.size()<6)
					JOptionPane.showMessageDialog(frame, "Does not exist!");  //error is assignment DNE
				else{
				list.getSubject(5).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(5); 
				cLabel6.setText("C6 " + temp); 			//changes C6 label
			}
			}			
			else if (answer.equals("Add Assignment to C7"))
			{
				if(list.size()<7)
					JOptionPane.showMessageDialog(frame, "Does not exist!"); //error if assignment DNE
				else{
				list.getSubject(6).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(6);
				cLabel7.setText("C7 " + temp);				//changes C7 label 
			}
			}
			else if (answer.equals("Add Assignment to C8"))
			{
				if(list.size()<8)
					JOptionPane.showMessageDialog(frame, "Does not exist!"); //error if assignment DNE
				else{
				list.getSubject(7).addAssignment(nameText, gradeNum);
				String temp = list.getSubjectString(7);
				cLabel8.setText("C8 " + temp);			//changes C8 label
			}
			}			
			else if(answer.equals("Add Subject"))  //adds subject to the class list 
			{
				Subject sub = new Subject(nameText); 	//subject to add, gets name from text box 
				list.addSubject(sub);					//adds subject to the end of the class list 
				String temp = list.getSubjectString(list.size()-1);	//string of the added subject 
				if(cLabel2.getText().equals("C2 " + null))	//changes next available label to the new subject 
				{
					cLabel2.setText("C2 " + temp); 
				}
				else if (cLabel3.getText().equals("C3 " + null))
				{
					cLabel3.setText("C3 " + temp); 
				}
				else if (cLabel4.getText().equals("C4 " + null))
				{
					cLabel4.setText("C4 " + temp); 
				}
				else if (cLabel5.getText().equals("C5 " + null))
				{
					cLabel5.setText("C5 " + temp); 
				}
				else if (cLabel6.getText().equals("C6 " + null))
				{
					cLabel6.setText("C6 " + temp); 
				}
				else if (cLabel7.getText().equals("C7 " + null))
				{
					cLabel7.setText("C7 " + temp); 
				}
				else if (cLabel8.getText().equals("C8 " + null))
				{
					cLabel8.setText("C8 " + temp); 
				}
				
				else{
					JOptionPane.showMessageDialog(frame, "Not enough space!"); //if no label available, show error message
				}
			}
			else if (answer.equals("Change a Subject Name"))
			{				
				Object [] possible = {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8" }; //possible options
				
				int n = JOptionPane.showOptionDialog(frame, "Choose Subject to Edit: ", 
						"Choose Subject", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, //pop up w/list of subjects to change
						null, possible, possible[7]); 
				if((n == 1 && list.size() < 2) || ( n==2 && list.size()<3) || (n==3 && list.size()< 4) ||
						(n==4 && list.size() < 5) || (n==5 && list.size() < 6) || (n==6 && list.size() < 7) 
						|| (n==7 && list.size() < 8)) 
				{
					JOptionPane.showMessageDialog(frame, "Error, subject not created yet"); //gives error if class DNE
					return;
				}
				
				String name = (String) JOptionPane.showInputDialog(frame, "Enter the new Subject Name: "
						+ "","Customize",JOptionPane.PLAIN_MESSAGE, null, null, null);  //gets new name
				if(name !=null && name.length() > 0 )
				{
					list.getSubject(n).changeName(name);  //sets new name to specified subject
					if(n==0)
						cLabel1.setText("C1 " + list.getSubjectString(0)); 
			
					if(n==1) 
						cLabel2.setText("C2 " +list.getSubjectString(1)); 
					
					if(n==2)
						cLabel3.setText("C3 " + list.getSubjectString(2)); 
					
					if(n==3)					
						cLabel4.setText("C4 " + list.getSubjectString(3)); 
				
					if(n==4)
						cLabel5.setText("C5 " + list.getSubjectString(4)); 
					
					if(n==5)
						cLabel6.setText("C6 " + list.getSubjectString(5));
					
					if(n==6)
						cLabel7.setText("C7 " + list.getSubjectString(6)); 
					
					if(n==7)
						cLabel8.setText("C8 " + list.getSubjectString(7)); 
					
				}
				
			}
			String newGpa= "" + list.getTotalGpa();  //gets new gpa  
			gpaLabel.setText("GPA: " + newGpa);		//changes gpa label to new gpa
			}

	});
	//other buttons to show reports for each class
	//a report displays the overall grade and grades for each assignment in the subject
	JButton c1button = new JButton("C1 Report"); 
	c1button.addActionListener(new ActionListener()	//shows report for class 1 
	{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame, list.getSubject(0).getReport());				
			}
	});		
	JButton c2button = new JButton("C2 Report"); 
	c2button.addActionListener(new ActionListener() //show report for class 2 if it exists
	{
		public void actionPerformed(ActionEvent a) {
			if(list.size()>=2){
				JOptionPane.showMessageDialog(frame, list.getSubject(1).getReport());} 
			else {
				JOptionPane.showMessageDialog(frame, "Subject does not exist!");}
				}
	});		
	JButton c3button = new JButton("C3 Report"); 
	c3button.addActionListener(new ActionListener() //show report for class 3 if it exists
	{
		public void actionPerformed(ActionEvent b) {
			if(list.size()>=3)
				JOptionPane.showMessageDialog(frame, list.getSubject(2).getReport());
			else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				}
	});		
	JButton c4button = new JButton("C4 Report"); 
	c4button.addActionListener(new ActionListener() //show report for class 4 if it exists
	{		
		public void actionPerformed(ActionEvent arg0) {
			if(list.size()>=4)
				JOptionPane.showMessageDialog(frame, list.getSubject(3).getReport());
			else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				}
	});
		
	JButton c5button = new JButton("C5 Report"); 
	c5button.addActionListener(new ActionListener()	//show report for class 5 if it exists 
	{
		public void actionPerformed(ActionEvent arg0) {
			if(list.size()>=5)
				JOptionPane.showMessageDialog(frame, list.getSubject(4).getReport());
			else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				}
	});		
	JButton c6button = new JButton("C6 Report"); 
	c6button.addActionListener(new ActionListener() //show report for class 6 if it exists
	{			
		public void actionPerformed(ActionEvent arg0) {
			if(list.size()>=6)
				JOptionPane.showMessageDialog(frame, list.getSubject(5).getReport());
			else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
	});		
	JButton c7button = new JButton("C7 Report"); 
	c7button.addActionListener(new ActionListener() //show report for class 7 if it exists 
	{			
		public void actionPerformed(ActionEvent arg0) {
			if(list.size()>=7)
				JOptionPane.showMessageDialog(frame, list.getSubject(6).getReport());
			else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
			}
	});
		
	JButton c8button = new JButton("C8 Report"); 
	c8button.addActionListener(new ActionListener() //show report for class 8 if it exists 
	{
			public void actionPerformed(ActionEvent arg0) {
				if(list.size()>=8)
					JOptionPane.showMessageDialog(frame, list.getSubject(7).getReport());
				else 
					JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
	});
	

	doPanel.add(assignLabel); 
	doPanel.add(assignNameField); 
	doPanel.add(gradeLabel);
	doPanel.add(assignGradeField); 
	doPanel.add(actions); 
	doPanel.add(doButton);
	doPanel.add(c1button);
	doPanel.add(c2button);					//adding everything to the doPanel
	doPanel.add(c3button);
	doPanel.add(c4button);
	doPanel.add(c5button);
	doPanel.add(c6button);
	doPanel.add(c7button);
	doPanel.add(c8button);
	basePanel.add(doPanel, BorderLayout.CENTER); 	//adding the doPanel to the basePanel 
	
	//panel that has button in case the user needs help using the student helper 
	JPanel helpPanel = new JPanel(new FlowLayout()); 
	JButton helpButton = new JButton("Help"); 
	helpButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(frame, "*Add classes and assignments to keep track of your grades and GPA \n*Choose and action from the "
					+ "drop down box, fill in the appropriate text fields, and press \"Enter\" to perform the action"
					+ "\n*The Report buttons display a pop up of the selected subject's listed assignments and overall score"
					+ "\n*Make sure the subject you are editing exists before editing the selected subject"
					+ "\n*If you add a subject, make sure you have at least one assignment in that subject, otherwise your GPA will drop");
			
		}
	}); 

	helpPanel.add(helpButton); 
	basePanel.add(helpPanel, BorderLayout.SOUTH); 
	
	//adding the whole basePanel to the frame 
	frame.add(basePanel);
	frame.setVisible(true); 
	
	//start up message 
	JOptionPane.showMessageDialog(frame, "Welcome to the StudentHelper!"
			+ " Add classes and assignments to keep track of your grades and GPA \nChoose and action from the "
			+ "drop down box, fill in the appropriate text fields, and press \"Enter\" to perform the action");
	
	
	
	
		
		
		
		
		
		
		

	}

}
