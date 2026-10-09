package lk.ijse.movie_ticket_booking_system.Entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.movie_ticket_booking_system.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Builder 
@Table (name="User")
public class UserEntity implements Serializable{
    @Id 
    private String userId;
    @Column(nullable = false)
    private String userName;
     @Column(unique = true,nullable = false)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

//user-booking
@OneToMany (mappedBy = "User")
private List<BookingEntity> Booking;
    
}
