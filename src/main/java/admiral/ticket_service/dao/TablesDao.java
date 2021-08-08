package admiral.ticket_service.dao;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TablesDao {
	
	@SqlUpdate("CREATE TYPE public.ticket_type AS ENUM (\r\n" + 
			"'prematch','live','virtual')")
	public void createTicketTypeEnum();
	
	
	@SqlUpdate("CREATE TYPE public.result AS ENUM (\r\n" + 
			"'win','lost','refund','waiting')")
	public void createResultEnum();
	
	
	
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS ticket_service.public.ticket (\r\n" + 
			"    id serial NOT NULL PRIMARY KEY,\r\n" + 
			"	ticket_number character varying(17),\r\n" + 
			"    ticket_type public.ticket_type NOT NULL, \r\n" + 
			"    bet_amount double precision NOT NULL,\r\n" + 
			"    quota double precision NOT NULL,\r\n" + 
			"    win_amount double precision NOT NULL,\r\n" + 
			"    result public.result DEFAULT 'waiting'::public.result NOT NULL,\r\n" + 
			"    creation_time timestamp without time zone DEFAULT now() NOT NULL ,\r\n" + 
			"    edit_time timestamp without time zone DEFAULT now() NOT NULL,\r\n" + 
			"    player_id integer)")
			public void createTicketTable();
	
	@SqlUpdate("CREATE UNIQUE INDEX IF NOT EXISTS creation_time_inx  ON ticket (creation_time)")
			public void createIndexOnTicketTable();
	
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS ticket_service.public.player (\r\n" + 
			"    id serial NOT NULL PRIMARY KEY,\r\n" + 
			"	 first_name character varying(50),\r\n" +
			"	 last_name character varying(50),\r\n" + 
			"	 email character varying(50))\r\n" + 
			"    ")
			public void createPlayerTable();
	
	
	@SqlUpdate("insert into player (first_name, last_name, email) \r\n" + 
			"values ('Nenad', 'Jasarevic', 'nenadjasarevic81@gmail.com')")
			public void insertPlayer();
	

	
	@SqlQuery("SELECT COUNT(ID) FROM player")
	public int playerCount();

}
