package lk.ijse.movie_ticket_booking_system.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lk.ijse.movie_ticket_booking_system.Enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lk.ijse.movie_ticket_booking_system.Enums.PaymentMethodStatus;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter
@Entity
@Builder
@Table (name="Payment")
public class PaymentEntity implements Serializable{
    @Id 
    private String paymentId;
     @Column(nullable = false)
    private BigDecimal amount;
     @Column(nullable = true)
    private LocalDate paymentDate;
     @Enumerated(EnumType.STRING)
    private PaymentMethodStatus pmstatus;
     @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    //booking-payment
    @OneToOne 
    @JoinColumn (name="booking_id")
    private BookingEntity Booking;


}
