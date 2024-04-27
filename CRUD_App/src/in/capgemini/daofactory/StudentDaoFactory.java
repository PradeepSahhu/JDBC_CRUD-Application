package in.capgemini.daofactory;

import java.sql.DriverManager;

import in.capgemini.persistence.IStudentDAO;
import in.capgemini.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDAO studentDao=null;
	
	private StudentDaoFactory() {
		
	}
	
	//Connection con=DriverManager.getConnection(null)
	
	public static IStudentDAO getStudentDAO() {
		if(studentDao==null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
