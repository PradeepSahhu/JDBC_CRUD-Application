package in.capgemini.persistence;

import in.capgemini.dto.Student;

public interface IStudentDAO {

	public String addStudent(Integer StudentUID, String StudentName, String StudentCourse, Integer StudentBatch);
	
	public Student selectStudent(Integer StudentUID);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer studentUID);
		
}
