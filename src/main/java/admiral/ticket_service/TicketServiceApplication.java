package admiral.ticket_service;

import java.sql.SQLException;

import org.skife.jdbi.v2.DBI;

import admiral.ticket_service.configuration.TicketServiceConfiguration;
import admiral.ticket_service.dbi.DBICreator;
import admiral.ticket_service.healthcheck.TemplateHealthCheck;
import admiral.ticket_service.resources.DataBaseResource;
import admiral.ticket_service.resources.HelloWorldResorce;
import admiral.ticket_service.resources.TablesResource;
import admiral.ticket_service.resources.TicketResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
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
		
		HelloWorldResorce helloResource = new HelloWorldResorce(
				configuration.getTemplate(), 
				configuration.getDefaultName());
		
		TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(
				configuration.getTemplate());
		
		DBI dbi = DBICreator.createDBI(configuration, environment, "");
		environment.jersey().register(new DataBaseResource(dbi));
		
		DBI dbi1 = DBICreator.createDBI(configuration, environment, "ticket_service?stringtype=unspecified");
				
		environment.jersey().register(helloResource);
		environment.jersey().register(templateHealthCheck);
		environment.jersey().register(new TablesResource(dbi1));
		environment.jersey().register(new TicketResource(dbi1));
		
		
	}

}
