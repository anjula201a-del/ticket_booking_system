package lk.ijse.movie_ticket_booking_system.dto;

import java.io.Serializable;
import lk.ijse.movie_ticket_booking_system.Enums.TheatreStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class TheatreDTO implements Serializable {
  private String theatreId;
  private String theatreName;
  private String location;
  private Integer capacity;
  private TheatreStatus status;

}

