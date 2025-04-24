package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.model.Bus;
import GLO4.getMyTicket_Backend.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;

    @Override
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Bus with id " + id + " not found")
        );
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus updateBus(Long id, Bus bus) {
        Bus bus2 = getBusById(id);
        bus2.setNumberOfPlaces(bus.getNumberOfPlaces());
        busRepository.save(bus2);
        return bus2;
    }

    @Override
    public void deleteBus(Long id) {
        Bus bus2 = getBusById(id);
        busRepository.delete(bus2);
    }
}
