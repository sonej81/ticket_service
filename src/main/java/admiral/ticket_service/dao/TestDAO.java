package admiral.ticket_service.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface TestDAO {

	@SqlQuery("select name from test_table")
	List<String> listNames();

}
