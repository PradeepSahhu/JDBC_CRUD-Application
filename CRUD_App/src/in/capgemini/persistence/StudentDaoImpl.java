package in.capgemini.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;

import in.capgemini.dbutil.JdbcUtil;
import in.capgemini.dto.Student;

public class StudentDaoImpl implements IStudentDAO {

	Connection connection=null;
	PreparedStatement psmt = null;
	JdbcUtil connectionObject = new JdbcUtil();
	ResultSet resultSet=null;
	int rowAffected = 0;
	Student student=new Student();
	
	@Override
	public String addStudent(Integer StudentUID, String StudentName, String StudentCourse, Integer StudentBatch) {
		String sqlInsertQuery = "insert into studentdb values(?,?,?,?)";
		connection = connectionObject.getConnection();
		if(connection!=null) 
			try {
				psmt = connection.prepareStatement(sqlInsertQuery);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		if(psmt!=null) {
					try {
					psmt.setInt(1, StudentUID);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					try {
					psmt.setString(2, StudentName);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					try {
					psmt.setString(3, StudentCourse);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					try {
					psmt.setInt(4, StudentBatch);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					try {
						rowAffected = psmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
					if(rowAffected>0) 
					
						return "success";
					else 
						return "failure";
	}
			
 

	@Override
	public Student selectStudent(Integer StudentUID) {
		
		String sqlSearchQuery = "select * from studentdb where StudentUID=?";
		connection = connectionObject.getConnection();
		if(connectionObject!=null)
			try {
				psmt=connection.prepareStatement(sqlSearchQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(psmt!=null) {
			try {
				psmt.setInt(1, StudentUID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				resultSet = psmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(resultSet!=null) {
			try {
				if(resultSet.next()) {
					student = new Student();
					student.setStudentUID(resultSet.getInt(1));
					student.setStudentName(resultSet.getString(2));
					student.setStudentCourse(resultSet.getString(3));
					student.setStudentBatch(resultSet.getInt(4));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		
		String sqlUpdateQuery = "update studentdb set StudentName=?, StudentCourse=?, StudentBatch=? where StudentUID=?";
		connection = connectionObject.getConnection();
		if(connection!=null) {
			try {
				psmt = connection.prepareStatement(sqlUpdateQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.setInt(4, student.getStudentUID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				psmt.setString(1, student.getStudentName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				psmt.setString(2, student.getStudentCourse());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				psmt.setInt(3, student.getStudentBatch());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			rowAffected = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowAffected==1) {
			return "success";
		}
		return "failure";
	}

	@Override
	public String deleteStudent(Integer studentUID) {
		String sqlDeleteQuery = "delete from studentdb where StudentUID=?";
		connection = connectionObject.getConnection();
		if(connection!=null) 
			try {
				psmt = connection.prepareStatement(sqlDeleteQuery);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		if(psmt!=null) {
					try {
					psmt.setInt(1, studentUID);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					
					try {
						rowAffected = psmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
					if(rowAffected>0) 
					
						return "success";
					else 
						return "failure";
		
	}

}
