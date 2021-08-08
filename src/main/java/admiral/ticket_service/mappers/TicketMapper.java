package admiral.ticket_service.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import admiral.ticket_service.enums.Result;
import admiral.ticket_service.enums.TicketType;
import admiral.ticket_service.models.LoggedPlayer;
import admiral.ticket_service.representation.Ticket;

public class TicketMapper implements ResultSetMapper<Ticket>{
	
	

	@Override
	public Ticket map(int index, ResultSet r, StatementContext ctx) throws SQLException {
	
		int id = r.getInt("id");
		TicketType ticket_type = TicketType.valueOf(r.getString("ticket_type"));
		double bet_amount = r.getDouble("bet_amount");
		double quota = r.getDouble("quota");
		double win_amount = r.getDouble("win_amount");
		Result result = Result.valueOf(r.getString("result"));
		LocalDateTime creation_time = r.getTimestamp("creation_time").toLocalDateTime();
		LocalDateTime edit_time = r.getTimestamp("edit_time").toLocalDateTime();
		int player_id = r.getInt("player_id");
		String first_name = r.getString("first_name");
		String last_name = r.getString("last_name");
		String email = r.getString("email");
		
		return new Ticket(id, ticket_type, bet_amount, quota,
				win_amount, result, creation_time, edit_time, 
				new LoggedPlayer(player_id, first_name, last_name, email));
	}

}
