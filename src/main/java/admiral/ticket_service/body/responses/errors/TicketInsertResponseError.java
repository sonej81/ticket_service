package admiral.ticket_service.body.responses.errors;

public class TicketInsertResponseError {
	
	private String message;
	
	public TicketInsertResponseError(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
