package admiral.ticket_service.responses;

import admiral.ticket_service.enums.Result;

public class TicketUpdateResponse {
	
	private String message;
	private Result result;
	private int id;
	
	
	public TicketUpdateResponse(String message, Result result, int id) {
		this.message = message;
		this.result = result;
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Result getResult() {
		return result;
	}


	public void setResult(Result result) {
		this.result = result;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	 
	
	
}
