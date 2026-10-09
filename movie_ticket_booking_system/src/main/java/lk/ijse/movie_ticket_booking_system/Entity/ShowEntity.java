package lk.ijse.movie_ticket_booking_system.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.movie_ticket_booking_system.Enums.ShowStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
@Entity 
@Builder 
@Table (name="Shows")
public class ShowEntity implements Serializable{
 @Id
 private String showId;
 @Column(nullable = false)
 private LocalDate showDate;
 @Column(nullable = false)
 private LocalTime showTime;
 @Column(nullable = false)
 private BigDecimal ticketPrice;
  @Enumerated(EnumType.STRING)
 private ShowStatus status;

 //show-booking
 @OneToMany (mappedBy = "Show")
 private List<BookingEntity> Bookings;

 //movie-show
 @ManyToOne 
 @JoinColumn (name="movie_id")
 @JsonIgnore 
 private MovieEntity Movie;

 //theatre-show
 @ManyToOne 
 @JoinColumn (name="theatre_id")
 @JsonIgnore 
  private TheatreEntity Theatre;

}
