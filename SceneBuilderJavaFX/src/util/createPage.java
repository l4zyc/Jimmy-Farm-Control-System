package util;

import resources.Data_Input_Catatan_Harian_Form;
import resources.Login;
import resources.Register;

public interface createPage {
	public static void loginpage() {
		new Login();
	}
	
	public static void registerPage() {
		new Register();
	}
	
	public static void DataInputCatatanHarian() {
		new Data_Input_Catatan_Harian_Form();
	}
}
