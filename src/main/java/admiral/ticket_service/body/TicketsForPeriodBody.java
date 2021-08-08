package admiral.ticket_service.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketsForPeriodBody {
	
	@JsonProperty("dtFrom")
	private  String dateFrom;
	
	@JsonProperty("dtTo")
	private  String dateTo;


	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	

}
