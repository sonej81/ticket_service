package admiral.ticket_service.dao;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import admiral.ticket_service.mappers.PlayerMapper;
import admiral.ticket_service.models.LoggedPlayer;

public interface PlayerDao {

	@SqlQuery("select * from Player where id= 1")
	@RegisterMapper(PlayerMapper.class)
	public LoggedPlayer findPlayer();
}
