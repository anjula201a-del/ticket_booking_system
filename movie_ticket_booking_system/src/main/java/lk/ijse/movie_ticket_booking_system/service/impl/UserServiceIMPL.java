package lk.ijse.movie_ticket_booking_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.DAO.UserDao;
import lk.ijse.movie_ticket_booking_system.Entity.UserEntity;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.dto.UserDTO;
import lk.ijse.movie_ticket_booking_system.service.UserService;
import lk.ijse.movie_ticket_booking_system.util.Conversion;
import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor 
@Transactional 
public class UserServiceIMPL implements UserService{
    private final UserDao userDao;
    private final Conversion conversion;

     @Override
    public UserDTO getSelectedUser(String userId) {
       UserEntity userEntity= userDao.findById(userId)
                               .orElseThrow(()-> new DataNotFoundException("user not found") );
        return conversion.toUserDTO(userEntity);
                                
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers =userDao.findAll();
        return conversion.toUserDTOList(allUsers);
    }

    @Override
    public void updateUser(String userId, UserDTO user) {
        UserEntity foundUser= userDao.findById(userId)
                               .orElseThrow(()-> new DataNotFoundException("user not found") );
                               foundUser.setEmail(user.getEmail());
                               foundUser.setRole(user.getRole());
                               foundUser.setUserName(user.getUserName());                            
                               foundUser.setPassword(user.getPassword());
                              
    }

    @Override
    @Transactional 
    public void deleteUser(String userId) {
        UserEntity foundUser= userDao.findById(userId)
                               .orElseThrow(()-> new DataNotFoundException("user not found") );
                               userDao.delete(foundUser);
       
    }
  
     

}
