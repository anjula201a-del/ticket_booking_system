package lk.ijse.movie_ticket_booking_system.service.secure;


import lk.ijse.movie_ticket_booking_system.dto.secure.JWTResponseDTO;
import lk.ijse.movie_ticket_booking_system.dto.secure.SignInDTO;
import lk.ijse.movie_ticket_booking_system.dto.secure.SignUpDTO;


public interface AuthService {
    JWTResponseDTO signIn(SignInDTO signIn);
     void signUp(SignUpDTO signUp);
}