package DbOperations;

public class GetEncryptedPassword {
	
	    public static String getEncryptedPassword(String password,String email) {	
		password=password.trim();
		String pass="";
		email=email.trim();
		String code=email.substring(0, 7);
		password=code+password;
		for(int i=0,j=57;i<password.length();i++,j=j+75) {
			pass = pass + (char)((int) password.charAt(i) + j);
		}
		return pass.substring(0,3)+pass.substring(7)+pass.substring(3,7);
	}
}
