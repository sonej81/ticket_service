package admiral.ticket_service.body.responses.errors;

public class TicketsForPeriodErrorResponse {
	
	private String message;
	
	public TicketsForPeriodErrorResponse(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
