package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.TicketRequestDTO;
import GLO4.getMyTicket_Backend.dto.TicketResponseDTO;
import GLO4.getMyTicket_Backend.model.Ticket;

import java.util.List;

public interface TicketService {
    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO);
    public TicketResponseDTO getTicketById(Long id);
    public Ticket findTicketById(Long id);
    public List<TicketResponseDTO> getAllTickets();
    public TicketResponseDTO updateTicket(Long id, TicketRequestDTO ticketRequestDTO);
    public void deleteTicket(Long id);
}
