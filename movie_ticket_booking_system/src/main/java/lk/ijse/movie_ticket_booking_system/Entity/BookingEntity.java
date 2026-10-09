package lk.ijse.movie_ticket_booking_system.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lk.ijse.movie_ticket_booking_system.Enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor  
@Getter 
@Setter 
@Entity  
@Table (name="Booking")
public class BookingEntity implements Serializable{
    @Id 
    private String bookingId;
     @Column(nullable = false)
    private List<String> seatNumbers = new ArrayList<>();
     @Column(nullable = false)
    private Integer numberOfTickets;
     @Column(nullable = false)
    private BigDecimal totalAmount;
     @Column(nullable = false)
    private LocalDate bookingDate;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
  
//user-booking
@ManyToOne 
@JoinColumn (name="user_id")
@JsonIgnore 
private UserEntity User;

//show-booking
@ManyToOne
@JoinColumn(name = "show_id")
private ShowEntity Show;

//booking-payment
@OneToOne (mappedBy = "Booking")
private PaymentEntity Payment;

}
