package lk.ijse.movie_ticket_booking_system.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.ijse.movie_ticket_booking_system.Entity.UserEntity;


public interface UserDao extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
