package gr.teiath.cs;

public class User {
	private String username;
	public static boolean exist;
	private String firstName = "";
	
	private String lastName = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		exist = true;
		this.username = username;
	}

	public String getFirstName() {
		exist = true;
		return firstName;
	}

	public void setFirstName(String firstName) {
		exist = true;
		this.firstName = firstName;
	}

	public String getLastName() {
		exist = true;
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void killuser(String lastName) {
		this.lastName = "";
		this.username = "";
	}
	
}
