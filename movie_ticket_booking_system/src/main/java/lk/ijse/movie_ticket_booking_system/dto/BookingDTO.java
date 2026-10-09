package lk.ijse.movie_ticket_booking_system.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.movie_ticket_booking_system.Enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor 
@NoArgsConstructor  
@Data 
public class BookingDTO implements Serializable{
    private String bookingId;
    private String userId;
    private String showId;
    private List<String> seatNumbers = new ArrayList<>();
    private Integer numberOfTickets;
    private BigDecimal totalAmount;
    private LocalDate bookingDate;
    private BookingStatus status;



}
