package in.capgemini.service;

import in.capgemini.daofactory.StudentDaoFactory;
import in.capgemini.dto.Student;
import in.capgemini.persistence.IStudentDAO;

public class StudentServiceImpl implements IStudentService {

	private IStudentDAO studentDao;
	@Override
	public String addStudent(Integer StudentUID, String StudentName, String StudentCourse, Integer StudentBatch) {
		studentDao = StudentDaoFactory.getStudentDAO();
		if(studentDao!=null)
			return studentDao.addStudent(StudentUID, StudentName, StudentCourse, StudentBatch);
		else
			return "failure";
	}

	@Override
	public Student selectStudent(Integer StudentUID) {
		studentDao = StudentDaoFactory.getStudentDAO();
		return studentDao.selectStudent(StudentUID);
	}

	@Override
	public String updateStudent(Student studentUID) {
		
		studentDao = StudentDaoFactory.getStudentDAO();
		return studentDao.updateStudent(studentUID);
	}

	@Override
	public String deleteStudent(Integer studentUID) {
		
		studentDao = StudentDaoFactory.getStudentDAO();
		return studentDao.deleteStudent(studentUID);
		
	}

}
