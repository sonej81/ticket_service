package admiral.ticket_service.body;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TicketsForPeriodValidator {

	TicketsForPeriodBody body;

	private final String WRONG_PATTERN_MESSAGE = "wong pattern for input date. "
			+ "The pattern must be i form: dd-MM-yyyy HH:mm:ss";
	private final String DATE_FROM_MISSING_MESSAGE = "dtFrom param missing";
	private final String DATE_TO_MISSING_MESSAGE = "dtTo param missing";

	public TicketsForPeriodValidator(TicketsForPeriodBody body) {
		this.body = body;
	}

	public String validateBody() {
	
		if(dateFromIsMissing()){
			return DATE_FROM_MISSING_MESSAGE;
		}
		
		if(dateToIsMissing()){
			return DATE_TO_MISSING_MESSAGE;
		}
		

		if (wrongDatePattern(body.getDateFrom()) || wrongDatePattern(body.getDateTo())) {
			return WRONG_PATTERN_MESSAGE;
		}

		return "";
	}

	
	private boolean dateFromIsMissing() {
		String dateFrom = body.getDateFrom();
		return dateFrom == null || dateFrom.isEmpty();
	}

	private boolean dateToIsMissing() {
		String dateTo = body.getDateTo();
		return dateTo == null || dateTo.isEmpty();
	}

	private boolean wrongDatePattern(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime.parse(date, formatter);
			return false;
		} catch (DateTimeParseException e) {
			return true;
		}
	}

}
