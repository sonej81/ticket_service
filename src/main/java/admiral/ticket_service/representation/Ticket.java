package admiral.ticket_service.representation;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import admiral.ticket_service.enums.Result;
import admiral.ticket_service.enums.TicketType;
import admiral.ticket_service.models.LoggedPlayer;

public class Ticket {
	
	
	private int id;
	
	private TicketType ticket_type;
	
	private double bet_amount;
	
	private double quota;
	
	private double win_amount;
	
	private Result result;
	
	private LoggedPlayer loggedPlayer;
	
	
	
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime creation_time;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime edit_time;
	
	
	
	public Ticket() {
		
	}
	

	public Ticket(int id, TicketType ticket_type, double bet_amount, double quota, double win_amount, Result result,
			LocalDateTime creation_time, LocalDateTime edit_time, LoggedPlayer loggedPlayer ) {
		this.id = id;
		this.ticket_type = ticket_type;
		this.bet_amount = bet_amount;
		this.quota = quota;
		this.win_amount = win_amount;
		this.result = result;
		this.creation_time = creation_time;
		this.edit_time = edit_time;
		this.loggedPlayer = loggedPlayer;
	}


	@JsonProperty
	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	@JsonProperty
	protected TicketType getTicket_type() {
		return ticket_type;
	}

	protected void setTicket_type(TicketType ticket_type) {
		this.ticket_type = ticket_type;
	}
	
	@JsonProperty
	protected double getBet_amount() {
		return bet_amount;
	}

	@JsonProperty
	protected void setBet_amount(double bet_amount) {
		this.bet_amount = bet_amount;
	}

	@JsonProperty
	protected double getQuota() {
		return quota;
	}


	protected void setQuota(double quota) {
		this.quota = quota;
	}
	
	@JsonProperty
	protected double getWin_amount() {
		return win_amount;
	}

	protected void setWin_amount(double win_amount) {
		this.win_amount = win_amount;
	}

	@JsonProperty
	protected Result getResult() {
		return result;
	}

	protected void setResult(Result result) {
		this.result = result;
	}

	@JsonProperty
	protected LocalDateTime getCreation_time() {
		return creation_time;
	}

	protected void setCreation_time(LocalDateTime creation_time) {
		this.creation_time = creation_time;
	}

	@JsonProperty
	protected LocalDateTime getEdit_time() {
		return edit_time;
	}

	protected void setEdit_time(LocalDateTime edit_time) {
		this.edit_time = edit_time;
	}

	@JsonProperty
	protected LoggedPlayer getLoggedPlayer() {
		return loggedPlayer;
	}


	protected void setLoggedPlayer(LoggedPlayer loggedPlayer) {
		this.loggedPlayer = loggedPlayer;
	}
	



	



	
	 
	

}
