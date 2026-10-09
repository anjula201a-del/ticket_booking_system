package lk.ijse.movie_ticket_booking_system.controller.secure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.movie_ticket_booking_system.dto.secure.JWTResponseDTO;
import lk.ijse.movie_ticket_booking_system.dto.secure.SignInDTO;
import lk.ijse.movie_ticket_booking_system.dto.secure.SignUpDTO;
import lk.ijse.movie_ticket_booking_system.service.secure.AuthService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("api/auth")
@RequiredArgsConstructor 
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpDTO signUpUser) {
        authService.signUp(signUpUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTResponseDTO> signIn(@RequestBody SignInDTO signInUser) {
        return ResponseEntity.ok(authService.signIn(signInUser));
    }
}