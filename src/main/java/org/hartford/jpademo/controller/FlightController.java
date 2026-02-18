package org.hartford.jpademo.controller;

import org.apache.coyote.Response;
import org.hartford.jpademo.model.Flight;
import org.hartford.jpademo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
//        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.addFlight(flight));
        return ResponseEntity.status(201).body(flightService.addFlight(flight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeFlight(@PathVariable Long id){
        if(flightService.deleteById(id)) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public List<Flight> getAllFlights(){
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @GetMapping("/{source}/{destination}/{departureDate}")
    public List<Flight> getFlight(@PathVariable String source, @PathVariable String destination, @PathVariable Date departureDate){
        return flightService.findBySourceAndDestinationAndDepartureDate(source,destination,departureDate);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlightById(@PathVariable Long id,@RequestBody Flight flight){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.updateFlightById(id,flight));
    }

}
