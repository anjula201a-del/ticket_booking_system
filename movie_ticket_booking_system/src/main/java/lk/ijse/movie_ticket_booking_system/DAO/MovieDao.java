package lk.ijse.movie_ticket_booking_system.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.ijse.movie_ticket_booking_system.Entity.MovieEntity;


public interface MovieDao extends JpaRepository<MovieEntity,String>{

}
