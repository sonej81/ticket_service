package admiral.ticket_service.resources;

import org.skife.jdbi.v2.DBI;

import admiral.ticket_service.dao.TablesDao;

public class TablesResource {
	
	TablesDao tablesDao;
	
	public TablesResource(DBI dbi){	
		tablesDao = dbi.onDemand(TablesDao.class);
		createTicketType();
		createResult();
		createTicketTable();
		createPlayerTable();
		insertPlayer();
	}
	

	private void createTicketType(){
		try {
			tablesDao.createTicketTypeEnum();
		} catch (Exception e) {
			System.out.println("ticket_type ENUM already exsists");
		}
		
	}
	
	private void createResult(){
		try {
			tablesDao.createResultEnum();
		} catch (Exception e) {
			System.out.println("result ENUM already exsists");
		}
		
	}
	
	private void createTicketTable(){
		tablesDao.createTicketTable();
		tablesDao.createIndexOnTicketTable();
	}
	
	private void createPlayerTable(){
		tablesDao.createPlayerTable();
	}
	
	private void insertPlayer(){
		
		if(tablesDao.playerCount() == 0){
		tablesDao.insertPlayer();
		}
	}

}
