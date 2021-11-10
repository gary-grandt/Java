package GGcrypt.dataStorage;

import java.util.ArrayList;

public class Email {
	public Email() {}
	public Email(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	// Variables
	private String email;
	private String password;
	
	private ArrayList<Account> accountList;
}
