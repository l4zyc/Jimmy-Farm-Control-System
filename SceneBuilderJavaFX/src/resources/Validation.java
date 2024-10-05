package resources;

public class Validation {
	public static boolean isAlphanumeric(String string) {
		for(int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			
            if (!(ch >= 48 && ch <= 57) &&  
                    !(ch >= 65 && ch <= 90) && 
                    !(ch >= 97 && ch <= 122)) { 
                    return false;  
            }
		}
		
		return true;
	}
}
