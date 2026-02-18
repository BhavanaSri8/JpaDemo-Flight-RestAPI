package org.hartford.jpademo.service;

import org.hartford.jpademo.model.Flight;
import org.hartford.jpademo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;
    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public boolean deleteById(Long id){
        if(flightRepository.existsById(id)){
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    public Flight findById(Long id){
        return flightRepository.findById(id).orElse(null);
    }

    public Flight updateFlightById(Long id,Flight flight){
        Flight f=findById(id);
        if(id==null){
            return null;
        }
        f.setSource(flight.getSource());
        f.setDestination(flight.getDestination());
        f.setDepartureDate(flight.getDepartureDate());
        flightRepository.save(f);
        return f;
    }

    public List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date departureDate) {
        if(source == null || source.trim().isEmpty() || destination == null || destination.trim().isEmpty() ||
                departureDate == null) {
            return null;
        }
        return flightRepository.findBySourceAndDestinationAndDepartureDate(source,destination,departureDate);
    }

}
