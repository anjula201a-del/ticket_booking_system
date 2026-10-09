package lk.ijse.movie_ticket_booking_system.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.movie_ticket_booking_system.Entity.MovieEntity;
import lk.ijse.movie_ticket_booking_system.Entity.ShowEntity;

@Repository
public interface ShowDao extends JpaRepository<ShowEntity, String> {

    List<ShowEntity> findByMovie(MovieEntity movie);

}