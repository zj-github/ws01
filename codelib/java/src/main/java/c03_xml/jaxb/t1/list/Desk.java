package c03_xml.jaxb.t1.list;

public class Desk {
	
	public Desk(int deskId,String studentName) {
		this.deskId = deskId;
		this.studentName = studentName;
	}
	public Desk( ) {
	}
	
	private int deskId;
	private String studentName;

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
