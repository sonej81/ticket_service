package admiral.ticket_service;

import org.skife.jdbi.v2.DBI;

import admiral.ticket_service.configuration.TicketServiceConfiguration;
import admiral.ticket_service.dbi.DBICreator;
import admiral.ticket_service.resources.DataBaseResource;
import admiral.ticket_service.resources.TablesResource;
import admiral.ticket_service.resources.TicketResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class TicketServiceApplication extends Application<TicketServiceConfiguration> {

	public static void main(String[] args) throws Exception {
		new TicketServiceApplication().run(args);
	}
	
	@Override
	public String getName() {
		return "Hello world";
	}
	
	@Override
	public void initialize(Bootstrap<TicketServiceConfiguration> bootstrap) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run(TicketServiceConfiguration configuration, Environment environment) throws Exception {
		
		
		
		DBI dbi = DBICreator.createDBI(configuration, environment, "");
		environment.jersey().register(new DataBaseResource(dbi));
		
		DBI dbi1 = DBICreator.createDBI(configuration, environment, "ticket_service?stringtype=unspecified");
				
	
		environment.jersey().register(new TablesResource(dbi1));
		environment.jersey().register(new TicketResource(dbi1));
				
	}

}
