package lk.ijse.movie_ticket_booking_system.service;

import java.util.List;

import lk.ijse.movie_ticket_booking_system.dto.UserDTO;

public interface UserService {
    UserDTO getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
    void updateUser(String userId,UserDTO user);
    void deleteUser(String userId);
}
