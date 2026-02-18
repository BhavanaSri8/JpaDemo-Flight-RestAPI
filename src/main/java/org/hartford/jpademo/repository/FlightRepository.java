package org.hartford.jpademo.repository;

import org.hartford.jpademo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date departureDate);
//    List<Flight> findAllBy(Sort.By())
}
