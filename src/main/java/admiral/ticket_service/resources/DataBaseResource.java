package admiral.ticket_service.resources;

import org.skife.jdbi.v2.DBI;

import admiral.ticket_service.dao.DataBaseDao;

public class DataBaseResource {
	
	DataBaseDao dataBaseDao;
	
	
	public DataBaseResource(DBI dbi){
		dataBaseDao = dbi.onDemand(DataBaseDao.class);
		createDataBase();
		}

	
	private void createDataBase(){
		try {
			dataBaseDao.createDataBase();
		} catch (Exception e) {
			System.out.println("DataBase is already created");
		}
	}

}
