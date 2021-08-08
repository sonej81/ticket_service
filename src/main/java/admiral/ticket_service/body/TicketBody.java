package admiral.ticket_service.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import admiral.ticket_service.enums.Result;
import admiral.ticket_service.enums.TicketType;

public class TicketBody {

	@JsonProperty("ticket_id")
	private int ticket_id;
	
	@JsonProperty("ticket_type")
	private TicketType ticket_type;
	
	@JsonProperty("bet_amount")
	private double bet_amount;
	
	@JsonProperty("quota")
	private double quota;
	
	@JsonProperty("win_amount")
	private double win_amount;
	
	@JsonProperty("result")
	private Result result;
	
	
	@JsonProperty("ticket_number")
	private String ticket_number;


	public int getTicket_id() {
		return ticket_id;
	}


	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}


	public TicketType getTicket_type() {
		return ticket_type;
	}


	public void setTicket_type(TicketType ticket_type) {
		this.ticket_type = ticket_type;
	}


	public double getBet_amount() {
		return bet_amount;
	}


	public void setBet_amount(double bet_amount) {
		this.bet_amount = bet_amount;
	}


	public double getQuota() {
		return quota;
	}


	public void setQuota(double quota) {
		this.quota = quota;
	}


	public double getWin_amount() {
		return win_amount;
	}


	public void setWin_amount(double win_amount) {
		this.win_amount = win_amount;
	}


	public Result getResult() {
		return result;
	}


	public void setResult(Result result) {
		this.result = result;
	}


	public String getTicket_number() {
		return ticket_number;
	}


	public void setTicket_number(String ticket_number) {
		this.ticket_number = ticket_number;
	}
	
	

}
