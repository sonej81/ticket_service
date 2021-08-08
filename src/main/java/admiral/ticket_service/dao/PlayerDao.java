package admiral.ticket_service.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import admiral.ticket_service.mappers.PlayerMapper;
import admiral.ticket_service.models.LoggedPlayer;
import admiral.ticket_service.representation.Ticket;

public interface PlayerDao {

	@SqlQuery("select * from Player where id= 1")
	@RegisterMapper(PlayerMapper.class)
	public LoggedPlayer findPlayer();
}
