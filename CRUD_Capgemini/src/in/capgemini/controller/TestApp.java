package in.capgemini.controller;

import java.util.Scanner;

import in.capgemini.dto.Student;
import in.capgemini.service.IStudentService;
import in.capgemini.servicefactory.StudentServiceFactory;

public class TestApp {
	public static void main(String args[]) {
		
//		System.out.println("Insertion Operating is Executing.......");
//		
//			insertOperation();
			
		System.out.println("Selection Operating is Executing.......");
			selectOperation();
			
//		System.out.println("Deletion Operating is Executing.......");
//			deleteOperation();
			
		System.out.println("Updation Operating is Executing.......");
			updateOperation();
			
			
		
	}

	private static void deleteOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Student UID to be deleted::");
		int studentUID = scanner.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg =studentService.deleteStudent(studentUID);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record deleted successfully");
		}
		else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("Record not available for the given student uid::"+studentUID);
		}
		else {
			System.out.println("Record deletion failed");
		}
//		scanner.close();
	}

	private static void selectOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student UID:");
		int sid = scanner.nextInt();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student studentObject = studentService.selectStudent(sid);
		if(studentObject.getStudentUID()==null) {
			System.out.println("Record not found for given student UID::"+sid);
			
		}
		else {
			System.out.println("StudentUID \t StudentName \t StudentCourse \t StudentBatch ");
			System.out.println(studentObject.getStudentUID() + "\t \t  " +studentObject.getStudentName()+ "\t \t  " +studentObject.getStudentCourse()+ "\t \t  " +studentObject.getStudentBatch());
		}
//		scanner.close();
	}

	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		System.out.println("Enter Student UID::");
		Integer sUID = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.println("Enter Student Name::");
		String sName = scanner.nextLine();
		
		System.out.println("Enter Student Course::");
		String sCourse = scanner.nextLine();
		
		System.out.println("Enter Student Batch::");
		Integer sBatch = scanner.nextInt();
		
		String message = studentService.addStudent(sUID, sName, sCourse, sBatch);
		if(message.equalsIgnoreCase("success")) {
			System.out.println("Record inserted successfully");
		}
		else {
			System.out.println("Record insertion failed");
		}
//		scanner.close();
	}
	
	private static void updateOperation() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student UID to be updated:: ");
		int studentUID = scanner.nextInt();
		scanner.nextLine();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.selectStudent(studentUID);
		if(student.getStudentUID()!=null) {
			Student newStudent = new Student();
			System.out.println("Student UID is:: "+student.getStudentUID());
			
			newStudent.setStudentUID(student.getStudentUID());
//			newStudent.setStudentUID(studentUID);
			
			
			System.out.println("Student old name is:: "+student.getStudentName()+"\nEnter new name::");
			String newName = scanner.nextLine();
			if(newName.trim().isEmpty() || newName=="") {
				newStudent.setStudentName(student.getStudentName());
//				newStudent.setStudentName(newName);
			}
			else {
				newStudent.setStudentName(newName);
			}
			System.out.println("Student old course is:: "+student.getStudentCourse()+"\nEnter new course::");
			String newCourse = scanner.next();
			if(newCourse.trim().isEmpty()) {
				newStudent.setStudentCourse(student.getStudentCourse());
			}
			else {
				newStudent.setStudentCourse(newCourse);
			}
			
			System.out.println("Student old batch is:: "+student.getStudentBatch()+"\nEnter new batch::");
			int newBatch = scanner.nextInt();
			if(newBatch==0) {
				newStudent.setStudentBatch(student.getStudentBatch());
			}
			else {
				newStudent.setStudentBatch(newBatch);
			}
			String status = studentService.updateStudent(newStudent);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Record updated successfully");
					}
					else {
						System.out.println("Record updation failed");
					}
			
		}
		
		
		
	}
}
