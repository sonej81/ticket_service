package admiral.ticket_service.models;

public  class LoggedPlayer {
	
	private  int player_id ;
	private  String first_name;
	private  String last_name;
	private  String email;
	
	 
	
	
	public LoggedPlayer(int player_id, String first_name, String last_name, String email) {
		this.player_id = player_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	
	

	public  int getPlayer_id() {
		return player_id;
	}
	
	public  String getFirst_name() {
		return first_name;
	}
	public  String getLast_name() {
		return last_name;
	}
	public  String getEmail() {
		return email;
	}
	
	

}
