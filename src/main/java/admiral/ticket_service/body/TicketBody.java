package admiral.ticket_service.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import admiral.ticket_service.enums.Result;
import admiral.ticket_service.enums.TicketType;

public class TicketBody {
	
	@JsonProperty("ticket_id")
	public int ticket_id;
	
	@JsonProperty("ticket_type")
	public TicketType ticket_type;
	
	@JsonProperty("bet_amount")
	public double bet_amount;
	
	@JsonProperty("quota")
	public double quota;
	
	@JsonProperty("win_amount")
	public double win_amount;
	
	@JsonProperty("result")
	public Result result;
	
	@JsonProperty("dtFrom")
	public String dateFrom;
	
	@JsonProperty("dtTo")
	public String dateTo;
	
	@JsonProperty("ticket_number")
	public String ticket_number;

}
