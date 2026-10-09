package lk.ijse.movie_ticket_booking_system.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JWTResponseDTO implements Serializable {
    String token;
}