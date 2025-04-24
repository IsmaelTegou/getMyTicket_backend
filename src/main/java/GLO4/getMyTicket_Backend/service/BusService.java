package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.model.Bus;

import java.util.List;

public interface BusService {
    public Bus createBus(Bus bus);
    public Bus getBusById(Long id);
    public List<Bus> getAllBuses();
    public Bus updateBus(Long id, Bus bus);
    public void deleteBus(Long id);
}
