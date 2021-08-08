package admiral.ticket_service.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;

import admiral.ticket_service.body.TicketBody;
import admiral.ticket_service.body.TicketBodyValidator;
import admiral.ticket_service.body.TicketsForPeriodBody;
import admiral.ticket_service.body.TicketsForPeriodValidator;
import admiral.ticket_service.body.responses.errors.TicketFindByIdResponseError;
import admiral.ticket_service.body.responses.errors.TicketInsertResponseError;
import admiral.ticket_service.body.responses.errors.TicketsForPeriodErrorResponse;
import admiral.ticket_service.dao.PlayerDao;
import admiral.ticket_service.dao.TicketDao;
import admiral.ticket_service.enums.Result;
import admiral.ticket_service.models.LoggedPlayer;
import admiral.ticket_service.representation.Ticket;
import admiral.ticket_service.representation.TicketsForPeriod;
import admiral.ticket_service.responses.TicketInsertResponse;
import admiral.ticket_service.responses.TicketUpdateResponse;


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
	public Response insertTicket (TicketBody body)  {
		
		String bodyValidationErrorMessage = ticketInsertErrorMessage(body);
		if(! bodyValidationErrorMessage.isEmpty()){		
			TicketInsertResponseError responseError = new TicketInsertResponseError(bodyValidationErrorMessage);
			return Response.status(400).entity(responseError).build();
		}
		
		String type =body.getTicket_type().name();
		double bet_amount = body.getBet_amount();
		double quota =body.getQuota();
		double win_amount = body.getWin_amount();
		int player_id = player.getPlayer_id();
		String ticket_number = body.getTicket_number();
		
		
	
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
		
		TicketUpdateResponse ticketUpdateResponse =
				new TicketUpdateResponse("a ticket successfully updated",
						result, ticket_id);
		return Response.status(200).entity(ticketUpdateResponse).build();
	}
	
	@GET
	@Path("/findById")
	public Response findTicketById(@QueryParam("ticket_id") int ticket_id) {
		Ticket ticket = ticketDao.findTicketById(ticket_id);
		
		if(ticket == null){
			TicketFindByIdResponseError responseError = 
					new TicketFindByIdResponseError(ticket_id); 
			return  Response.status(400).entity(responseError).build();
		}
		
		return  Response.status(200).entity(ticket).build();
	}
	
	@GET
	@Path("/forPeriod")
	public Response findTicketCreatedInPeriod(TicketsForPeriodBody body) {
		
		String errorMessage = ticketsForPeriodErrorMessage(body);
		if(!errorMessage.isEmpty()){
			TicketsForPeriodErrorResponse responseError = 
					new TicketsForPeriodErrorResponse(errorMessage);
			return Response.status(400).entity(responseError).build();	
		}
		
		String dateFrom = body.getDateFrom();
		String dateTo =body.getDateTo();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
		LocalDateTime dtFrom = LocalDateTime.parse(dateFrom, formatter);
		LocalDateTime dtTo = LocalDateTime.parse(dateTo, formatter);
		
		List<Ticket> tickets = ticketDao.findTicketCreatedInPeriod(dtFrom, dtTo);
		TicketsForPeriod ticketsForPeriod = new TicketsForPeriod(tickets);
		
		return Response.status(200).entity(ticketsForPeriod).build();
	}
	
	
	
	private String ticketInsertErrorMessage (TicketBody body){
		TicketBodyValidator validator = new TicketBodyValidator(body);
		return validator.validateBody();
	}
	
	private String ticketsForPeriodErrorMessage(TicketsForPeriodBody body){
		TicketsForPeriodValidator validator = new TicketsForPeriodValidator(body);
		return validator.validateBody();
	}
	
	
}
