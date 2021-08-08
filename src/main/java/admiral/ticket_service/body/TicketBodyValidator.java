package admiral.ticket_service.body;

import admiral.ticket_service.enums.TicketType;

public class TicketBodyValidator {
	
	private TicketBody body;
	
	private final int TICKET_NUMBER_LENGTH = 17;
	private final double MIN_BET_AMOUNT = 2.0;
	
	private final String TICKET_NUMBER_TOO_LONG_MESSAGE = "Ticket number is too long";
	private final String TICKET_NUMBER_MISSING_MESSAGE = "ticket_number param is missing";
	private final String BET_AMOUNT_MISSING_MESSAGE = "bet_amount param missing";
	private final String BET_AMOUNT_SMALLER_THEN_MIN_MESSAGE = "Bet amount smaller then min bet amount 2$";
	private final String WRONG_TICKET_TYPE_MESSAGE  = "Wrong ticket type. It mast be live, prematch or virtual";
	private final String TICKET_TYPE_IS_MISSING_MESSAGE = "ticket_type param is missing";
	private final String QUOTA_IS_MISSING_MESSAGE = "quota param is missing";
	private final String WIN_AMOUNT_IS_MISSING_MESSAGE = "win_amount param is missing";


	 
	
	public TicketBodyValidator(TicketBody body){
		this.body = body;
	}
	
	public String validateBody(){
		
		if(ticketNumberIsMissing()){
			return TICKET_NUMBER_MISSING_MESSAGE;
		}
		
		if(ticketNumberTooLong()){
			return TICKET_NUMBER_TOO_LONG_MESSAGE;
		}
		
		if(ticketTypeIsMissing()){
			return TICKET_TYPE_IS_MISSING_MESSAGE;
		}
		
		if(wrongTicketType()){
			return WRONG_TICKET_TYPE_MESSAGE;
		}
		
		if(betAmountMissing()){
			return BET_AMOUNT_MISSING_MESSAGE;
		}
		
		if(betAmountSmallerThenMinimum()){
			return BET_AMOUNT_SMALLER_THEN_MIN_MESSAGE;
		}
		
		if(quotaMissing()){
			return QUOTA_IS_MISSING_MESSAGE;
		}
		
		if(winAmountMissing()){
			return WIN_AMOUNT_IS_MISSING_MESSAGE;
		}
		
		return "";
	}
	
	
	
	private boolean ticketNumberTooLong(){
		String ticket_number = body.getTicket_number();
		return ticket_number.length() > TICKET_NUMBER_LENGTH;
	}
	
	private boolean ticketNumberIsMissing(){
		String ticket_number = body.getTicket_number();
		return ticket_number == null || ticket_number.isEmpty();
	}
	
	private boolean ticketTypeIsMissing(){
		TicketType ticket_type = body.getTicket_type();
		return ticket_type == null;
	}
	
	private boolean wrongTicketType(){
		TicketType[] types = TicketType.values();
		
		for(TicketType t: types){
			TicketType ticket_type = body.getTicket_type();
			if(t == ticket_type){
				return false;
			}
		}
		
		return true;
	}
	
	
	private boolean betAmountMissing(){
		double bet_amount = body.getBet_amount();
		return bet_amount <=0;
	}
	
	private boolean betAmountSmallerThenMinimum( ){
		double bet_amount = body.getBet_amount();
		return bet_amount < MIN_BET_AMOUNT;
	}
	
	private boolean quotaMissing(){
		double quota = body.getQuota();
		return quota <=0;
	}
	
		
	private boolean winAmountMissing(){
		double win_amount = body.getQuota();
		return win_amount <=0;
	}

}
