package DbOperations;
public class GetDecryptedPassword {
	    
	    public static String getDecryptedPassword(String password,String email) {
	    	password=password.trim();
			password=password.substring(0,3)+password.substring(password.length()-4)+password.substring(3,password.length()-4);
			String pass="";
			email=email.trim();
			String code=email.substring(0, 7);
			for(int i=0,j=57;i<password.length();i++,j=j+75) {
				pass = pass + (char)((int) password.charAt(i) - j);
			}
			return pass.replace(code, "");
	}

}
