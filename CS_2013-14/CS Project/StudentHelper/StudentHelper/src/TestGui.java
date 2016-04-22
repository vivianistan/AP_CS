import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestGui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String gpa; //Strings
		final JLabel nameLabel, gpaLabel, cLabel1, cLabel2, cLabel3, cLabel4, cLabel5, cLabel6, cLabel7, cLabel8; //labels
		final JTextField nameBox;
		
		final Font subjectFont = new Font("Arial", Font.PLAIN, 18); 	 //font for subjects	
		
		//Scanners
		//Scanner stringScanner = new Scanner(System.in); 
		//Scanner doubleScanner = new Scanner(System.in); 	
		
		//Initial stuff
		Assignment csProject = new Assignment("CS Project", 100); //initial assignment

		Subject compSci = new Subject("Computer Science"); //initial subject
		compSci.addAssignment(csProject);

			final ClassList list = new ClassList("Semester1"); //creating list of classes
			list.addSubject(compSci); //adding initial subject
			
			//gathering subject and class info once
			System.out.println("Welcome to StudentHelper!\nAdd subjects and assignment scores to your first semester to find your GPA");
			/*int count = 0; 
			while(count <=0){
				
				System.out.println("Add a subject to " + list.getName() +"? (y/n)"); 
				String answer = stringScanner.nextLine();
				count++; 
				
				if(answer.compareTo("n") != 0){
					System.out.println("Name of subject?"); 
					String name = stringScanner.nextLine();
					Subject sub = new Subject(name); 
					list.addSubject(sub);
					
					int c2 = 0;
					
					while(c2<=0){
					System.out.println("Add an assignment to " + sub.getName() + "? (y/n)");  
					String ans = stringScanner.nextLine();
					c2++; 
					if(ans.compareTo("n") != 0)
					{
						System.out.println("Name of assignment?");
						String name2 = stringScanner.nextLine();
						System.out.println("Score?");
						double num = doubleScanner.nextDouble();
						sub.addAssignment(name2, num);
						ans = ""; 
						c2--; 
					}
					
					}
					count--; 		
				}
			}
			*/
			gpa = ""+ list.getTotalGpa(); 
			final String class1 = list.getSubjectString(0);
			final String class2 ;
			final String class3 ; 
			final String class4 ; 
			final String class5 ; 
			final String class6 ;
			final String class7 ; 
			final String class8 ; 
			int numSubjects = list.size();
			
			//sets strings equal to class names mentioned
			if(numSubjects>=2)
			{
				class2 = list.getSubjectString(1);
			}
				else  class2 = null;  
			if(numSubjects>=3)
			{
				class3 = list.getSubjectString(2); 
			}
				else  class3 = null;  
			if(numSubjects>=4)
			{
				class4 = list.getSubjectString(3);
			}
				else  class4 = null; 
			if(numSubjects>=5)
			{
				class5 = list.getSubjectString(4);
			}
				else class5 = null; 
			if(numSubjects>= 6)
			{
				class6 = list.getSubjectString(5);
			}
				else class6 = null;
			if(numSubjects>=7){
				class7 =list.getSubjectString(6);
			}
			else class7 = null; 
			if(numSubjects>=8)
			{
				class8 = list.getSubjectString(7); 
			}
			else class8 = null; 
			
			//note, only works well if all assignments are weighed equally

		//make frame
		final JFrame frame = new JFrame(); 		
		frame.setTitle("Test GUI For StudentHelper");
		frame.setSize(700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Overall Panel
		JPanel basePanel = new JPanel(new BorderLayout());
		
		//Name and GPA
		JPanel namePanel = new JPanel(new GridLayout());
			//labels
			nameLabel = new JLabel("Your Name Here", JLabel.LEFT); 
			nameLabel.setFont(new Font("Arial", Font.BOLD, 20)); //change font			
			gpaLabel = new JLabel("GPA: " + gpa);
			gpaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			
			//box
			nameBox = new JTextField("Enter Name");
		
			//button+listener
			JButton nameButton = new JButton("Set Name"); 
			nameButton.addActionListener(new ActionListener()
			{ 
				public void actionPerformed(ActionEvent e) 
				{
					nameLabel.setText(nameBox.getText());
				}
			});
		
			//add components
			namePanel.add(nameLabel); 
			namePanel.add(gpaLabel);
			namePanel.add(nameBox);
			namePanel.add(nameButton);
			//add name panel
			basePanel.add(namePanel,BorderLayout.NORTH);
		
		//Class List + grades
		JPanel classPanel = new JPanel(new GridLayout(8,1));
			cLabel1 = new JLabel("C1 " + class1); 
			cLabel2 = new JLabel("C2 " + class2); 
			cLabel3 = new JLabel("C3 " + class3); 
			cLabel4 = new JLabel("C4 " + class4); 
			cLabel5 = new JLabel("C5 " + class5);
			cLabel6 = new JLabel("C6 " + class6);
			cLabel7 = new JLabel("C7 " + class7); 
			cLabel8 = new JLabel("C8 " + class8);
			//fonts
			cLabel1.setFont(subjectFont);
			cLabel2.setFont(subjectFont);
			cLabel3.setFont(subjectFont); 
			cLabel4.setFont(subjectFont);
			cLabel5.setFont(subjectFont);
			cLabel6.setFont(subjectFont);
			cLabel7.setFont(subjectFont); 
			cLabel8.setFont(subjectFont);
			//add to panel
			classPanel.add(cLabel1); 
			classPanel.add(cLabel2);
			classPanel.add(cLabel3);
			classPanel.add(cLabel4);
			classPanel.add(cLabel5);
			classPanel.add(cLabel6);
			classPanel.add(cLabel7);
			classPanel.add(cLabel8);
			
		//add class panel
		basePanel.add(classPanel, BorderLayout.WEST);	
		
		//panel that changes things 
		JPanel doPanel = new JPanel(new GridLayout(7,2)); 
			//combo box, gives options
		String[] actionString = { "Add Assignment to C1","Add Assignment to C2",
				"Add Assignment to C3","Add Assignment to C4","Add Assignment to C5",
				"Add Assignment to C6","Add Assignment to C7","Add Assignment to C8", 
				 "Add Subject"}; 
		final JComboBox<String> actions = new JComboBox<String>(actionString); 
		actions.setSelectedIndex(8);
			//boxes to get info
		JLabel gradeLabel = new JLabel("Grade: ", JLabel.RIGHT); 
		JLabel assignLabel = new JLabel("Subject/Assignment Name: ", JLabel.RIGHT);
		final JTextField assignGradeField = new JTextField("Grade Here"); 
		final JTextField assignNameField = new JTextField("Write Here");
		JButton doButton = new JButton("Enter"); 
		//action listener 
		doButton.addActionListener(new ActionListener()		
			{
				public void actionPerformed(ActionEvent e)
				{
				String answer = (String) actions.getSelectedItem(); 
				String nameText = assignNameField.getText(); 
				double gradeNum = 0; 
				if(assignGradeField.getText().equals("Grade Here") != true){
					gradeNum = Double.parseDouble(assignGradeField.getText());
				}
				 
				if(answer.equals("Add Assignment to C1"))
					{
					list.getSubject(0).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(0); 
					cLabel1.setText("C1 " + temp);
					}
				else if(answer.equals("Add Assignment to C2"))
				{
					if(list.size()<2)//show error if assignment does not exist yet
					JOptionPane.showMessageDialog(frame, "Does not exist!"); 
					
					else{
					list.getSubject(1).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(1);
					cLabel2.setText("C2 " + temp);
					}
				}
				else if(answer.equals("Add Assignment to C3"))
					{
					if(list.size()<3)
						JOptionPane.showMessageDialog(frame, "Does not exist!");
					else{
					list.getSubject(2).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(2);
					cLabel3.setText("C3 " + temp); 
					}
					}
				else if(answer.equals("Add Assignment to C4"))
					{
					if(list.size()<4)
						JOptionPane.showMessageDialog(frame, "Does not exist!");
					else{
					list.getSubject(3).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(3);
					cLabel4.setText("C4 " + temp);
					}
					}
				else if(answer.equals("Add Assignment to C5"))
				{
					if(list.size()<5)
						JOptionPane.showMessageDialog(frame, "Does not exist!");
					else{
					list.getSubject(4).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(4); 
					cLabel5.setText("C5 " + temp);
				}
				}
				
				else if(answer.equals("Add Assignment to C6"))
				{
					if(list.size()<6)
						JOptionPane.showMessageDialog(frame, "Does not exist!");
					else{
					list.getSubject(5).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(5); 
					cLabel6.setText("C6 " + temp); 
				}
				}
				
				else if (answer.equals("Add Assignment to C7"))
				{
					if(list.size()<7)
						JOptionPane.showMessageDialog(frame, "Does not exist!");
					else{
					list.getSubject(6).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(6);
					cLabel7.setText("C7 " + temp);
				}
				}
				else if (answer.equals("Add Assignment to C8"))
				{
					if(list.size()<8)
						JOptionPane.showMessageDialog(frame, "Does not exist!");
					else{
					list.getSubject(7).addAssignment(nameText, gradeNum);
					String temp = list.getSubjectString(7);
					cLabel8.setText("C8 " + temp);
				}
				}
				
				else if(answer.equals("Add Subject"))
				{
					Subject sub = new Subject(nameText); 
					list.addSubject(sub);
					String temp = list.getSubjectString(list.size()-1);
					if(cLabel2.getText().equals("C2 " + null))
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
						JOptionPane.showMessageDialog(frame, "Not enough space!");
					}
				}
				
				
				String newGpa= "" + list.getTotalGpa(); 
				gpaLabel.setText("GPA: " + newGpa);
				}
	
		});
		
		JButton c1button = new JButton("C1 Report"); 
		c1button.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(frame, list.getSubject(0).getReport());				
				}
	});
		
		JButton c2button = new JButton("C2 Report"); 
		c2button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				if(list.size()>=2){
				JOptionPane.showMessageDialog(frame, list.getSubject(1).getReport());}
				else {
				JOptionPane.showMessageDialog(frame, "Does not exist!");}
				
				//System.out.println("done"); 
			}
		});
		
		JButton c3button = new JButton("C3 Report"); 
		c3button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				// TODO Auto-generated method stub
				if(list.size()>=3)
				JOptionPane.showMessageDialog(frame, list.getSubject(2).getReport());
				else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
		});
		
		JButton c4button = new JButton("C4 Report"); 
		c4button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(list.size()>=4)
				JOptionPane.showMessageDialog(frame, list.getSubject(3).getReport());
				else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
		});
		
		JButton c5button = new JButton("C5 Report"); 
		c5button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(list.size()>=5)
				JOptionPane.showMessageDialog(frame, list.getSubject(4).getReport());
				else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
		});
		
		JButton c6button = new JButton("C6 Report"); 
		c6button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(list.size()>=6)
				JOptionPane.showMessageDialog(frame, list.getSubject(5).getReport());
				else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
		});
		
		JButton c7button = new JButton("C7 Report"); 
		c7button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(list.size()>=7)
				JOptionPane.showMessageDialog(frame, list.getSubject(6).getReport());
				else 
				JOptionPane.showMessageDialog(frame, "Does not exist!");
				
			}
		});
		
		JButton c8button = new JButton("C8 Report"); 
		c8button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
		doPanel.add(c2button);
		doPanel.add(c3button);
		doPanel.add(c4button);
		doPanel.add(c5button);
		doPanel.add(c6button);
		doPanel.add(c7button);
		doPanel.add(c8button);
		
		//add do panel panel
		basePanel.add(doPanel, BorderLayout.CENTER); 
		//classPanel.add(doPanel); 

		//add everything
		frame.add(basePanel);
		frame.setVisible(true); 
		
	//To Do: Edit Subjects (remove, change name), change layout?  and view assignments? 
		//JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
		

	}

}
