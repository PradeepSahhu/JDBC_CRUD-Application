package in.capgemini.servicefactory;

import in.capgemini.service.IStudentService;
import in.capgemini.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static IStudentService studentService = null;
	
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentServic() {
		if(studentService==null) {
			studentService = new StudentServiceImpl();
			
		}
		return studentService;
	}
	
	
	
}
