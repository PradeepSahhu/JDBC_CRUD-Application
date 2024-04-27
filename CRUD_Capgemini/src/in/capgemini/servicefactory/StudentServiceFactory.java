package in.capgemini.servicefactory;

import in.capgemini.service.IStudentService;
import in.capgemini.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static IStudentService studentService = null; // reference variable later it will become object.
	
	private StudentServiceFactory() { // why this is private?
		
	}
	
	
	
	// Connection con = null; // here con is the reference variable 
	// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuims","root","Pradeep@2002"); // here con becomes object
	
	public static IStudentService getStudentService() {
		if(studentService==null) {
			
			studentService = new StudentServiceImpl();
			
			
		}
		return studentService;
	}
	
	
	
}
