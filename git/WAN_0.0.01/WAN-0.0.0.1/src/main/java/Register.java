import DbOperations.*;
public class Register {

	private String email;
	private String password;
	private String name;
	private String splcode;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword(String email) {
		if(this.email.equalsIgnoreCase(email)) return  password;
		else return null;
	}
	public void setPassword(String password,String em) {
		this.password = GetEncryptedPassword.getEncryptedPassword(password,em);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSplcode() {
		return splcode;
	}
	public void setSplcode(String splcode) {
		this.splcode = splcode;
	}
	
}
