package lk.ijse.movie_ticket_booking_system.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import lk.ijse.movie_ticket_booking_system.Enums.ShowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class ShowDTO implements Serializable{
 private String showId;
 private String movieId;
 private String theatreId;
 private LocalDate showDate;
 private LocalTime showTime;
 private BigDecimal ticketPrice;
 private ShowStatus status;


}
