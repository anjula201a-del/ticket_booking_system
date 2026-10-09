package lk.ijse.movie_ticket_booking_system.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lk.ijse.movie_ticket_booking_system.Enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lk.ijse.movie_ticket_booking_system.Enums.PaymentMethodStatus;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class PaymentDTO implements Serializable{
    private String paymentId;
    private String bookingId;
    private BigDecimal amount;
    private LocalDate paymenDate;
    private PaymentMethodStatus pmstatus;
    private PaymentStatus status;

}
