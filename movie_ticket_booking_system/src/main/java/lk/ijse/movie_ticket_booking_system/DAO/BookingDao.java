package lk.ijse.movie_ticket_booking_system.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.ijse.movie_ticket_booking_system.Entity.BookingEntity;
import lk.ijse.movie_ticket_booking_system.Entity.ShowEntity;


public interface BookingDao extends JpaRepository<BookingEntity,String> {
   @Query("SELECT b FROM BookingEntity b WHERE b.Show = :show")
    List<BookingEntity> findByShow(@Param("show") ShowEntity show);
}
