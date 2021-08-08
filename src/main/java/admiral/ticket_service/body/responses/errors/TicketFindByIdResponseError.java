package admiral.ticket_service.body.responses.errors;

public class TicketFindByIdResponseError {
	
	private final String TICKET_NOT_FOUND_MESSAGE = "Ticket not found";
	private int id;
	
	public TicketFindByIdResponseError(int id){
		this.id = id;
	}
	
	public synchronized int getId() {
		return id;
	}
	public synchronized void setId(int id) {
		this.id = id;
	}
	public synchronized String getTICKET_NOT_FOUND_MESSAGE() {
		return TICKET_NOT_FOUND_MESSAGE;
	}
	
	

	

}
