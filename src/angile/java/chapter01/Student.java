package angile.java.chapter01;

public class Student {
	private String name;
	
	public Student(String name){
		this.setName(name);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
