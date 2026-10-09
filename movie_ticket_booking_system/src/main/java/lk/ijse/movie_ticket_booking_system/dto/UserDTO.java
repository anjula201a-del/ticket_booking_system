package lk.ijse.movie_ticket_booking_system.dto;

import java.io.Serializable;
import lk.ijse.movie_ticket_booking_system.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class UserDTO implements Serializable{
    private String userId;
    private String userName;
    private String email;
    private String password;
    private Role role;

}
