package lk.ijse.movie_ticket_booking_system.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
@Builder 
public class SignInDTO {
 private String email;
 private String password;
}
