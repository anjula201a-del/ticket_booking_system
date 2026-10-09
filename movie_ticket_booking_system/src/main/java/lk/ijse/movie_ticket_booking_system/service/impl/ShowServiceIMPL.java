package lk.ijse.movie_ticket_booking_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.DAO.BookingDao;
import lk.ijse.movie_ticket_booking_system.DAO.MovieDao;
import lk.ijse.movie_ticket_booking_system.DAO.PaymentDao;
import lk.ijse.movie_ticket_booking_system.DAO.ShowDao;
import lk.ijse.movie_ticket_booking_system.DAO.TheatreDao;
import lk.ijse.movie_ticket_booking_system.Entity.BookingEntity;
import lk.ijse.movie_ticket_booking_system.Entity.MovieEntity;
import lk.ijse.movie_ticket_booking_system.Entity.ShowEntity;
import lk.ijse.movie_ticket_booking_system.Entity.TheatreEntity;
import lk.ijse.movie_ticket_booking_system.Enums.BookingStatus;
import lk.ijse.movie_ticket_booking_system.Enums.MovieStatus;
import lk.ijse.movie_ticket_booking_system.Enums.TheatreStatus;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.Exceptions.InvalidRequestException;
import lk.ijse.movie_ticket_booking_system.dto.ShowDTO;
import lk.ijse.movie_ticket_booking_system.service.ShowService;
import lk.ijse.movie_ticket_booking_system.util.Conversion;
import lk.ijse.movie_ticket_booking_system.util.IDGenerate;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
@Transactional 
public class ShowServiceIMPL implements ShowService {
    private final ShowDao showDao;
    private final MovieDao movieDao;
    private final TheatreDao theatreDao;
    private final BookingDao bookingDao;
    private final PaymentDao paymentDao;
    private final Conversion conversion;


     @Override
    public void createShow(ShowDTO show) {

        MovieEntity movie = movieDao.findById(show.getMovieId())
                .orElseThrow(() -> new DataNotFoundException("Movie not found"));

        if (movie.getStatus() == MovieStatus.ENDED) {
            throw new InvalidRequestException(
                    "Cannot create a show for a movie that has ended: " + movie.getTitle());
        }

        TheatreEntity theatre = theatreDao.findById(show.getTheatreId())
                .orElseThrow(() -> new DataNotFoundException("Theatre not found"));


         if (theatre.getStatus() == TheatreStatus.INACTIVE) {
            throw new InvalidRequestException(
                    "Cannot create a show for an inactive theatre: " + theatre.getTheatreName());
        }

        ShowEntity showEntity = conversion.toshowEntity(show);
        showEntity.setShowId(IDGenerate.showId());
        showEntity.setMovie(movie);

        showDao.save(showEntity);
    }

     @Override
    public ShowDTO getSelectedShow(String showId) {
    ShowEntity showEntity= showDao.findById(showId)
                               .orElseThrow(()-> new DataNotFoundException("show not found") );
        return conversion.toShowDTO(showEntity);
                                
    }

    @Override
    public List<ShowDTO> getAllShows() {
        List<ShowEntity> allShows =showDao.findAll();
        return conversion.toShowDTOList(allShows);
    }

   @Override
public void updateShow(String showId, ShowDTO show) {
    ShowEntity foundshow = showDao.findById(showId)
            .orElseThrow(() -> new DataNotFoundException("show not found"));

    if (foundshow.getMovie().getStatus() == MovieStatus.ENDED) {
        throw new InvalidRequestException(
                "Cannot update a show for a movie that has ended: " + foundshow.getMovie().getTitle());
    }

    if (foundshow.getTheatre().getStatus() == TheatreStatus.INACTIVE) {
        throw new InvalidRequestException(
                "Cannot update a show for an inactive theatre: " + foundshow.getTheatre().getTheatreName());
    }

    foundshow.setStatus(show.getStatus());
    foundshow.setShowDate(show.getShowDate());
    foundshow.setShowTime(show.getShowTime());
    foundshow.setTicketPrice(show.getTicketPrice());
}

    @Override
    public void deleteShow(String showId) {
        ShowEntity foundshow = showDao.findById(showId)
                .orElseThrow(() -> new DataNotFoundException("show not found"));

        List<BookingEntity> bookings = bookingDao.findByShow(foundshow);

        boolean hasActiveBooking = bookings.stream()
                .anyMatch(b -> b.getStatus() != BookingStatus.CANCELLED);

        if (hasActiveBooking) {
            throw new InvalidRequestException(
                    "Cannot delete this show because it has active (non-cancelled) bookings.");
        }

        for (BookingEntity booking : bookings) {
            if (booking.getPayment() != null) {
                paymentDao.delete(booking.getPayment());
            }
        }
        bookingDao.deleteAll(bookings);

        showDao.delete(foundshow);
    }
 


}