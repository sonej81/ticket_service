package admiral.ticket_service.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;

import com.google.common.base.Throwables;

import admiral.ticket_service.body.TicketBody;
import admiral.ticket_service.body.TicketBodyValidator;
import admiral.ticket_service.body.responses.errors.TicketInsertResponseError;
import admiral.ticket_service.dao.PlayerDao;
import admiral.ticket_service.dao.TicketDao;
import admiral.ticket_service.enums.Result;
import admiral.ticket_service.exeptions.TicketNumberFormException;
import admiral.ticket_service.models.LoggedPlayer;
import admiral.ticket_service.representation.Ticket;
import admiral.ticket_service.representation.TicketsForPeriod;
import admiral.ticket_service.responses.TicketInsertResponse;


@Path("/ticket")
@Produces(MediaType.APPLICATION_JSON)
public class TicketResource {
	
	private final TicketDao ticketDao;
	private final PlayerDao playerDao;
	private LoggedPlayer player;
	
	public TicketResource(DBI dbi) {
		ticketDao = dbi.onDemand(TicketDao.class);
		playerDao = dbi.onDemand(PlayerDao.class);
		player = playerDao.findPlayer();
	}
	
	
	@POST
	@Path("/insert")
	public Response insertTicket (TicketBody body) throws TicketNumberFormException {
		
		String bodyValidationErrorMessage = ticketInsertErrorMessage(body);
		if(! bodyValidationErrorMessage.isEmpty()){		
			TicketInsertResponseError responseError = new TicketInsertResponseError(bodyValidationErrorMessage);
			return Response.status(400).entity(responseError).build();
		}
		
		String type =body.ticket_type.name();
		double bet_amount = body.bet_amount;
		double quota = body.quota;
		double win_amount = body.win_amount;
		int player_id = player.getPlayer_id();
		String ticket_number = body.ticket_number;
		
		
	
		ticketDao.insert(type, bet_amount,quota,win_amount, player_id, ticket_number);
		
		TicketInsertResponse ticketInsertResponse = new TicketInsertResponse
				("a ticket successfully inserted into the database", 
				ticket_number, bet_amount, quota, win_amount);
		
		return Response.status(200).entity(ticketInsertResponse).build();
	}
	
	
	@POST
	@Path("/update")
	public Response updateTicket(@QueryParam ("ticket_id") int ticket_id,
								 @QueryParam ("result") Result result) {
		
		ticketDao.update(ticket_id, result);
		return Response.ok().build();
	}
	
	@GET
	@Path("/getById")
	public Ticket findTicketById(@QueryParam("ticket_id") int ticket_id) {
		return ticketDao.findTicketById(ticket_id);
	}
	
	@GET
	@Path("/forPeriod")
	public TicketsForPeriod findTicketCreatedInPeriod(TicketBody body) {
		
		String dateFrom = body.dateFrom;
		String dateTo = body.dateTo;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		LocalDateTime dtFrom = LocalDateTime.parse(dateFrom, formatter);
		LocalDateTime dtTo = LocalDateTime.parse(dateTo, formatter);
		List<Ticket> tickets = ticketDao.findTicketCreatedInPeriod(dtFrom, dtTo);
		return new TicketsForPeriod(tickets);
	}
	
	private String ticketInsertErrorMessage (TicketBody body){
		TicketBodyValidator validator = new TicketBodyValidator(body);
		return validator.validateBody();
	}
	
	
}
