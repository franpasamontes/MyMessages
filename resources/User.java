
public class User {

	private int idUser;
	private String name;
	private String email;
	
	//Constructors
	public User(){
		this.idUser = 9999;
	}
	
	public User(int _idUser, String _name, String _email){
		this.idUser = _idUser;
		this.name = _name;
		this.email = _email;
	}
	
	//Get and set methods
	public int getId(){
		return this.idUser;
	}
	
	public void setName(String _name){
		this.name = _name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setEmail(String _email){
		this.email = _email;
	}
	
	public String getEmail(){
		return this.email;
	}
}
