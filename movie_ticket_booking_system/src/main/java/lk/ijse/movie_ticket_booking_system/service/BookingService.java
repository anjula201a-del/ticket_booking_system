package lk.ijse.movie_ticket_booking_system.service;

import java.util.List;

import lk.ijse.movie_ticket_booking_system.dto.BookingDTO;

public interface BookingService {
    void createBooking(BookingDTO booking);
    BookingDTO getSelectedBooking(String bookingId);
    List<BookingDTO> getAllBookings();
    void updateBooking(String bookingId,BookingDTO booking);
  

}
