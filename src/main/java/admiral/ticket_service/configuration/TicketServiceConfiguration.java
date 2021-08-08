package admiral.ticket_service.configuration;





import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class TicketServiceConfiguration extends Configuration {

	@NotEmpty
	private String template;

	@NotEmpty
	private String defaultName;

	
	@NotNull
	private DataSourceFactory dataSourceFactory;

	@JsonProperty
	public String getTemplate() {
		return template;
	}

	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}

	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
		this.dataSourceFactory = dataSourceFactory;
	}
	
	

}
