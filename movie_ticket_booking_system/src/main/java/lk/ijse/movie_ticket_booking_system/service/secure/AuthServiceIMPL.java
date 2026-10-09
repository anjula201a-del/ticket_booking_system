package lk.ijse.movie_ticket_booking_system.service.secure;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.DAO.UserDao;
import lk.ijse.movie_ticket_booking_system.Entity.UserEntity;
import lk.ijse.movie_ticket_booking_system.Enums.Role;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.Exceptions.DuplicateException;
import lk.ijse.movie_ticket_booking_system.util.JWTUtil;
import lk.ijse.movie_ticket_booking_system.dto.secure.JWTResponseDTO;
import lk.ijse.movie_ticket_booking_system.dto.secure.SignInDTO;
import lk.ijse.movie_ticket_booking_system.dto.secure.SignUpDTO;
import lk.ijse.movie_ticket_booking_system.util.IDGenerate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceIMPL implements AuthService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @Override
    public void signUp(SignUpDTO signUp) {
        if (userDao.existsByEmail(signUp.getEmail())) {
            throw new DuplicateException("Email is already registered: " + signUp.getEmail());
        }

        UserEntity user = new UserEntity();
        user.setUserId(IDGenerate.userId());
        user.setUserName(signUp.getUserName());
        user.setEmail(signUp.getEmail());
        user.setPassword(passwordEncoder.encode(signUp.getPassword()));
        user.setRole(signUp.getRole() != null ? signUp.getRole() : Role.CUSTOMER);

        userDao.save(user);
    }

    @Override
    public JWTResponseDTO signIn(SignInDTO signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword())
        );

        UserEntity user = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new DataNotFoundException("User not found: " + signIn.getEmail()));

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name(), user.getUserId());

        return new JWTResponseDTO(
                token
        );
    }
}