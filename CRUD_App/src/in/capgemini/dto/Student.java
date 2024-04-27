package in.capgemini.dto;

import java.io.Serializable;

public class Student implements Serializable {


	private static final long serialVersionUID = 1L;
	private Integer studentUID;
	private String studentName;
	private String studentCourse;
	private Integer studentBatch;
	public Integer getStudentUID() {
		return studentUID;
	}
	public void setStudentUID(Integer studentUID) {
		this.studentUID = studentUID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	public Integer getStudentBatch() {
		return studentBatch;
	}
	public void setStudentBatch(Integer studentBatch) {
		this.studentBatch = studentBatch;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Student [studentUID=" + studentUID + ", studentName=" + studentName + ", studentCourse=" + studentCourse
				+ ", studentBatch=" + studentBatch + "]";
	}
	
	
	

}
