package schoolproject;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	private Date dob;
	private HBCU schoolType;
	private String type;
	private Student student;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Student getStudent() {
		return getStudent();
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public HBCU getSchoolType1() {
		return schoolType;
	}
	public void setSchoolType1(HBCU schoolType1) {
		this.schoolType = schoolType1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getType() {
		return getType();
		
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	//Student student = (Student) super.clone();
	//SchoolType schoolType1 = (schoolType) student.getSchoolType1().clone();
	//student.setschoolType(SchoolType);
	//return student;

}
