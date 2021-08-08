
package admiral.ticket_service.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.skife.jdbi.v2.DBI;

import com.codahale.metrics.annotation.Timed;

import admiral.ticket_service.dao.TestDAO;
import admiral.ticket_service.representation.DbTesting;


@Path("/dbTest")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
	
	private TestDAO testDAO;
	
	public TestResource(final DBI jdbi) {
		testDAO = jdbi.onDemand(TestDAO.class);
	}
	
	@GET
	@Timed
	public DbTesting getTesting(){
		List<String> results = testDAO.listNames();
		return new DbTesting(results);
	}

}
