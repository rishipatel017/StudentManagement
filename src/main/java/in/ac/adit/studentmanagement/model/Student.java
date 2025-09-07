package in.ac.adit.studentmanagement.model;

public class Student {
	private String studentid;
	private String firstname;
	private String lastname;
	private String email;
	private String course;
	private String gender;
	private String password;
	
	public String getStudentid() {
		return studentid;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getCourse() {
		return course;
	}
	public String getGender() {
		return gender;
	}
	public String getPassword() {
		return password;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", course=" + course + ", gender=" + gender + ", password=" + password + "]";
	}
	
}
