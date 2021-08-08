package admiral.ticket_service.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import admiral.ticket_service.models.LoggedPlayer;

public class PlayerMapper implements ResultSetMapper<LoggedPlayer> {

	@Override
	public LoggedPlayer map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		int id = r.getInt("id");
		String first_name = r.getString("first_name");
		String last_name = r.getString("last_name");
		String email = r.getString("email");
		
		return new LoggedPlayer(id, first_name, last_name, email);
	}

}
