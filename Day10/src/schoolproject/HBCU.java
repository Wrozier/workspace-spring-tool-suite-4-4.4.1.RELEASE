package schoolproject;

public class HBCU implements Cloneable {
	
	private String type;
	private String duration;
	
	
	public HBCU() {
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getType() {
		return type;
		
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "SchoolType [type" + type + ", duration= " + duration + "]";
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		// Copy constructor approach
		// SchoolTy
		return student;
	}

}
