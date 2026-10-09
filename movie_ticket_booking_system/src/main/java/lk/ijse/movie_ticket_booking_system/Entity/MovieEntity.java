package lk.ijse.movie_ticket_booking_system.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lk.ijse.movie_ticket_booking_system.Enums.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
@Entity 
@Builder 
@Table (name="Movie")
public class MovieEntity implements Serializable {
    @Id 
    private String movieId;
     @Column(nullable = false)
    private String title;
     @Column(nullable = false)
    private String description;
     @Column(nullable = false)
    private Integer duration;
     @Column(nullable = false)
    private String language;
     @Column(nullable = false)
    private String genre;
     @Column(nullable = false)
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private MovieStatus status;

   //movie-show
   @OneToMany (mappedBy ="Movie")
   private List<ShowEntity> Show;
   


}
