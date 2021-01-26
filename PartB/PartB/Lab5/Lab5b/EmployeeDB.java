import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EmployeeDB {
	JLabel jlab;
	static final String dbClass = "com.mysql.jdbc.Driver";
	
	EmployeeDB() {
		JButton jbtnMin = new JButton("Min Salary");
		JButton jbtnMax = new JButton("Max Salary");
// Create a new JFrame container.
		JFrame jfrm = new JFrame("Employee Details");
// Specify GridLayout for the layout manager.
		jfrm.setLayout(new GridLayout(3,1));
// Specify FlowLayout for the layout manager.
// jfrm.setLayout(new FlowLayout(FlowLayout.CENTER));
// Give the frame an initial size.
		jfrm.setSize(300, 300);
// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Make two buttons.
// Add action listener for Alpha.
		jbtnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fetchDatabase(1);
			}
		});
// Add action listener for Max.
		jbtnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fetchDatabase(2);
			}
		});
// Add the buttons to the content pane.
		jfrm.add(jbtnMin);
		jfrm.add(jbtnMax);
// Create a text-based label.
		jlab = new JLabel("Press a button.",JLabel.CENTER);
// Add the label to the content pane.
		jfrm.add(jlab);
// Display the frame.
		jfrm.setVisible(true);
	}

	void fetchDatabase(int code){
		java.sql.Connection conn = null;
		try
		{
			Class.forName(dbClass).newInstance();
			conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/COMPANY?user=root&password=root123");
		}catch(ClassNotFoundException e){
			System.out.println("error in loading driver"+e);
			System.exit(1);
		}
		catch(Exception e){
		System.out.println("error in connection"+e);
		System.exit(0);
		}
		
		try{
			java.sql.Statement s = conn.createStatement();
			String query1 = "SELECT * FROM `EMPLOYEE` WHERE emp_sal IN (SELECT MIN(emp_sal) FROM EMPLOYEE)";
			String query2 = "SELECT * FROM `EMPLOYEE` WHERE emp_sal IN (SELECT MAX(emp_sal) FROM EMPLOYEE)";
			java.sql.ResultSet r;
			
			if(code == 1){
				r = s.executeQuery(query1);
			}else{
				r = s.executeQuery(query2);
			}
			
			if(r.next()){
				jlab.setText(r.getString("emp_id")+ " | " +
				r.getString("emp_name") + " | Rs " +
				r.getString("emp_sal") + "/-");
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
		
			public void run() {
				new EmployeeDB();
			}
		});
	}
}

