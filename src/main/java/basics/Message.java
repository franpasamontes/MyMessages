package basics;

public class Message {

	private int userId;
	private String msg;
	
	//Constructors
	public Message(int _userId, String _msg){
		this.userId = _userId;
		this.msg = _msg;
	}
	
	//Get and set methods
	public int getUserId(){
		return this.userId;
	}
	
	public void setMsg(String _msg){
		this.msg = _msg;
	}
	
	public String getMsg(){
		return this. msg;
	}
}
