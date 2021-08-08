package admiral.ticket_service.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface DataBaseDao {
	
	@SqlUpdate("CREATE DATABASE ticket_service WITH  OWNER = postgres" +
    " ENCODING = 'UTF8'  CONNECTION LIMIT = -1")
	public void createDataBase();
	
}


