package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.ReservationRequestDTO;
import GLO4.getMyTicket_Backend.dto.ReservationResponseDTO;
import GLO4.getMyTicket_Backend.model.Reservation;
import GLO4.getMyTicket_Backend.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;


    @Override
    public ReservationResponseDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Reservation with id " + id + " not found")
        );
        return mapToDTO(reservation);
    }

    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Reservation with id " + id + " not found")
        );
    }

    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = Reservation.builder()
                .id(reservationRequestDTO.getId())
                .reservationDate(reservationRequestDTO.getReservationDate())
                .status(false)
                .user(reservationRequestDTO.getUser())
                .build();

        return mapToDTO(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        return reservationRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = findReservationById(id);
        reservation.setReservationDate(reservationRequestDTO.getReservationDate());
        reservation.setUser(reservationRequestDTO.getUser());

        reservationRepository.save(reservation);

        return mapToDTO(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = findReservationById(id);
        reservationRepository.delete(reservation);

    }

    private ReservationResponseDTO mapToDTO(Reservation reservation) {
       return ReservationResponseDTO.builder()
                .id(reservation.getId())
                .status(reservation.status)
                .numCNIClient(reservation.getUser().getNumCNI())
                .reservationDate(reservation.getReservationDate())
                .firstNameClient(reservation.getUser().getFirstName())
                .lastNameClient(reservation.getUser().getLastName())
                .build();
    }
}
