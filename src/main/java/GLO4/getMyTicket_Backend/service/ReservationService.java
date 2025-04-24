package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.ReservationRequestDTO;
import GLO4.getMyTicket_Backend.dto.ReservationResponseDTO;
import GLO4.getMyTicket_Backend.model.Reservation;

import java.util.List;

public interface ReservationService {
    public ReservationResponseDTO getReservationById(Long id);
    public Reservation findReservationById(Long id);
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO);
    public List<ReservationResponseDTO> getAllReservations();
    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO reservationRequestDTO);
    public void deleteReservation(Long id);
}
