package admiral.ticket_service.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import admiral.ticket_service.enums.Result;
import admiral.ticket_service.mappers.TicketMapper;
import admiral.ticket_service.representation.Ticket;

public interface TicketDao {
	
	@SqlUpdate("insert into ticket "
			+ "(ticket_type, bet_amount,"
			+ "quota, win_amount, "
			+ "player_id, ticket_number) "
			+ "values "
			+ "(:ticket_type, :bet_amount,"
			+ ":quota, :win_amount,"
			+ ":player_id, :ticket_number)")
	
	void insert (@Bind("ticket_type") String  ticket_type,
				@Bind("bet_amount") double bet_amount,
				@Bind("quota") double qouta,
				@Bind("win_amount") double win_amount,
				@Bind("player_id") int player_id,
				@Bind("ticket_number") String ticket_number);
	
	
	@SqlUpdate("update Ticket set result = :result, edit_time = now() where id = :ticket_id")
	void update(@Bind("ticket_id") int  ticket_id,
				@Bind("result") Result result);
	
	
	 
	
	
	
	@SqlQuery("select t.*, p.first_name, p.last_name, p.email from ticket t \r\n"  
			+  "join player p on t.player_id = p.id "
			+ " where creation_time between :dtFrom and :dtTo")
	@RegisterMapper(TicketMapper.class)
	public List<Ticket> findTicketCreatedInPeriod(@Bind("dtFrom") LocalDateTime dtFrom,
											@Bind("dtTo") LocalDateTime dtTo);

	
	@SqlQuery("select t.*, p.first_name, p.last_name, p.email from ticket t \r\n"  
			  + "join player p on t.player_id = p.id\r\n" 
			  + "where t.id = :ticket_id")
	@RegisterMapper(TicketMapper.class)
	public Ticket findTicketById(@Bind("ticket_id") int ticket_id);
	
	
}
