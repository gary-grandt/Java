package GGcrypt.dataStorage;

public class Account {
	public Account() {}
	public Account(Email email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	// Variables 
	private Email email;
	private String username;
	private String password;
}
