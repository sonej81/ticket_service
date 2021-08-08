package admiral.ticket_service.responses;

import org.eclipse.jetty.util.component.Dumpable;

public class TicketInsertResponse {
	
	String message;
	String ticket_number;
	double bet_amount;
	double quota;
	double win_amount;
	
	
	public TicketInsertResponse(String message, String ticket_number, double bet_amount, double quota,
			double win_amount) {
		this.message = message;
		this.ticket_number = ticket_number;
		this.bet_amount = bet_amount;
		this.quota = quota;
		this.win_amount = win_amount;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getTicket_number() {
		return ticket_number;
	}


	public void setTicket_number(String ticket_number) {
		this.ticket_number = ticket_number;
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
	
	
	

}
