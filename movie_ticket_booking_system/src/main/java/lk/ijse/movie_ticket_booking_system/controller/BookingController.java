package lk.ijse.movie_ticket_booking_system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.movie_ticket_booking_system.dto.BookingDTO;
import lk.ijse.movie_ticket_booking_system.service.BookingService;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/bookings")
@RestController 
@RequiredArgsConstructor 
public class BookingController {

    private final BookingService bookingService;
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBooking(@RequestBody BookingDTO bookingDTO) {
        logger.info("Incoming create booking detail is {}", bookingDTO);
        bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDTO> getSelectedBooking(@PathVariable String bookingId) {
        return new ResponseEntity<>(bookingService.getSelectedBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookingDTO>> getBooking() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{bookingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBooking(@PathVariable String bookingId, @RequestBody BookingDTO bookingDTO) {
        bookingService.updateBooking(bookingId, bookingDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}