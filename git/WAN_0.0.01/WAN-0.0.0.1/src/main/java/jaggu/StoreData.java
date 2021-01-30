package jaggu;

import java.util.Random;
public class StoreData {
	public static String storeId(String MyEmail,String yourEmail){
		if(yourEmail.equals(MyEmail)) {return "Don't enter your email";}
		if(!ChechChat.check(yourEmail)) {return "The person email not in data try with correct details";}
		String mess=StoreData.storedb(MyEmail,yourEmail);
		if(mess.equalsIgnoreCase("error")) {return "error in chat create of your database";}
		else if(mess.equalsIgnoreCase("otherEndChat")){ return "otherEndChat avilable get it check";}
		else if(mess.equalsIgnoreCase("otherEndChaterror")){ return "other EndChat avilable error";}
		else if(mess.equalsIgnoreCase("already")) {return "already user in previous chat";}
		else{return "successfull";}
	}
	public static String storedb(String MyEmail,String yourEmail) {
		try {
			if(ChechChat.check(MyEmail,yourEmail)) {	return "already";  }
			else if(!ChechChat.checkCross(MyEmail, yourEmail).equals("")) { 
				String dbname=ChechChat.checkCross(MyEmail, yourEmail);
				boolean b=ChechChat.crossStore(MyEmail, yourEmail, dbname);
				if(b) {return "otherEndChat";}
				return "otherEndChaterror";
			}
			Random r=new Random();
			String charectersDb="chatersDataBase"+r.nextInt(999999999);
			if(!ChechChat.createChat(MyEmail, yourEmail, charectersDb)) {return "error";}
			return "success";
		}
		catch(Exception e) {}
		return "error";
		}	
}
