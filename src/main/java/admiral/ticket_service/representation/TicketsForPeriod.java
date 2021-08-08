package admiral.ticket_service.representation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketsForPeriod {
	
	private List<Ticket> tickets;

	public TicketsForPeriod(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@JsonProperty
	protected List<Ticket> getTickets() {
		return tickets;
	}
	
	

}
