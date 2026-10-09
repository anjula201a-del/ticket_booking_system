package lk.ijse.movie_ticket_booking_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.DAO.BookingDao;
import lk.ijse.movie_ticket_booking_system.DAO.ShowDao;
import lk.ijse.movie_ticket_booking_system.Entity.BookingEntity;
import lk.ijse.movie_ticket_booking_system.Entity.ShowEntity;
import lk.ijse.movie_ticket_booking_system.Enums.ShowStatus;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.Exceptions.InvalidRequestException;
import lk.ijse.movie_ticket_booking_system.dto.BookingDTO;
import lk.ijse.movie_ticket_booking_system.service.BookingService;
import lk.ijse.movie_ticket_booking_system.util.Conversion;
import lk.ijse.movie_ticket_booking_system.util.IDGenerate;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
@Transactional 
public class BookingServiceIMPL implements BookingService {
    private final BookingDao bookingDao;
    private final ShowDao showDao;
    private final Conversion conversion;


     @Override
    public void createBooking(BookingDTO booking) {

        ShowEntity show = showDao.findById(booking.getShowId())
                .orElseThrow(() -> new DataNotFoundException("Show not found"));

        if (show.getStatus() == ShowStatus.CANCELLED || show.getStatus() == ShowStatus.COMPLETED) {
            throw new InvalidRequestException(
                    "Cannot book a show that is " + show.getStatus());
        }

        BookingEntity bookingEntity = conversion.toBookingEntity(booking);
        bookingEntity.setBookingId(IDGenerate.bookingId());
        bookingEntity.setShow(show);

        bookingDao.save(bookingEntity);
    }

     @Override
    public BookingDTO getSelectedBooking(String bookingId) {
    BookingEntity bookingEntity= bookingDao.findById(bookingId)
                               .orElseThrow(()-> new DataNotFoundException("booking not found") );
        return conversion.toBookingDTO(bookingEntity);
                                
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<BookingEntity> allBookings =bookingDao.findAll(); 
        return conversion.toBookingDTOList(allBookings);
    }

    @Override
    public void updateBooking(String bookingId,BookingDTO booking) {
      BookingEntity foundbooking= bookingDao.findById(bookingId)
                               .orElseThrow(()-> new DataNotFoundException("booking not found") );
                               foundbooking.setStatus(booking.getStatus());
                               foundbooking.setNumberOfTickets(booking.getNumberOfTickets());
                               foundbooking.setTotalAmount(booking.getTotalAmount());
                               foundbooking.setBookingDate(booking.getBookingDate());
                               foundbooking.setSeatNumbers(booking.getSeatNumbers());
                             
                               
                           
                              
    }

}
