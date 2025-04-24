package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.TicketRequestDTO;
import GLO4.getMyTicket_Backend.dto.TicketResponseDTO;
import GLO4.getMyTicket_Backend.model.Ticket;
import GLO4.getMyTicket_Backend.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = Ticket.builder()
                .id(ticketRequestDTO.getId())
                .trajet(ticketRequestDTO.getTrajet())
                .bus(ticketRequestDTO.getBus())
                .horaire(ticketRequestDTO.getHoraire())
                .reservation(ticketRequestDTO.getReservation())
                .build();
        ticketRepository.save(ticket);

        return mapToDTO(ticket);
    }

    @Override
    public TicketResponseDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Ticket with id " + id + " not found")
        );

        return mapToDTO(ticket);
    }

    @Override
    public Ticket findTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Ticket with id " + id + " not found")
        );
    }

    @Override
    public List<TicketResponseDTO> getAllTickets() {
        return ticketRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public TicketResponseDTO updateTicket(Long id, TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = findTicketById(id);
        ticket.setTrajet(ticketRequestDTO.getTrajet());
        ticket.setBus(ticketRequestDTO.getBus());
        ticket.setHoraire(ticketRequestDTO.getHoraire());
        ticket.setReservation(ticketRequestDTO.getReservation());
        ticketRepository.save(ticket);

        return mapToDTO(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticket = findTicketById(id);
        ticketRepository.delete(ticket);
    }

    private TicketResponseDTO mapToDTO(Ticket ticket) {
        return TicketResponseDTO.builder()
                .id(ticket.getId())
                .trajet(ticket.getTrajet())
                .numBus(ticket.getBus().getNumBus())
                .horaire(ticket.getHoraire())
                .numCNIClient(ticket.getReservation().getUser().getNumCNI())
                .nomClient(ticket.getReservation().getUser().getLastName())
                .prenomClient(ticket.getReservation().getUser().getFirstName())
                .build();
    }
}
