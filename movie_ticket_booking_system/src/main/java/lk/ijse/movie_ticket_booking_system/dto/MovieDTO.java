package lk.ijse.movie_ticket_booking_system.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lk.ijse.movie_ticket_booking_system.Enums.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class MovieDTO implements Serializable {
    private String movieId;
    private String title;
    private String description;
    private Integer duration;
    private String language;
    private String genre;
    private LocalDate releaseDate;
    private MovieStatus status;


}
