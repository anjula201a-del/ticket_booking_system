package lk.ijse.movie_ticket_booking_system.dto.secure;

import lk.ijse.movie_ticket_booking_system.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignUpDTO {
    private String userName;
    private String email;
    private String password;
    private Role role;
}