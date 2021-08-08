package admiral.ticket_service.representation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DbTesting {
	
	private List<String> results;
	
	public  DbTesting() {
	}
	
	

	public DbTesting(List<String> results) {
		this.results = results;
		
	}



	@JsonProperty
	protected List<String> getResults() {
		return results;
	}

	
}
