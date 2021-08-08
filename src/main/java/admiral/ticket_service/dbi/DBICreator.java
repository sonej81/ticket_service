package admiral.ticket_service.dbi;

import org.skife.jdbi.org.antlr.runtime.tree.RewriteRuleNodeStream;
import org.skife.jdbi.v2.DBI;

import admiral.ticket_service.configuration.TicketServiceConfiguration;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

public class DBICreator {
	
	public static DBI createDBI(TicketServiceConfiguration configuration, 
			Environment environment,
			String dbUri){
		
		String connectionUri = configuration.getDataSourceFactory().getUrl();
		String completeUri = addDataBaseNameToURI(connectionUri, dbUri);
		
		configuration.getDataSourceFactory().setUrl(completeUri);
		
		DBIFactory factory = new DBIFactory();
		DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql"+dbUri);
		
		return dbi;
	}
	
	
	private static String addDataBaseNameToURI(String connectionUri, String dbUri){
	
		StringBuilder sb = new StringBuilder();
		sb.append(connectionUri);
		sb.append(dbUri);
		
		return sb.toString();
		
	}

}
