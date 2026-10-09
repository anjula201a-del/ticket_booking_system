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
import lk.ijse.movie_ticket_booking_system.Enums.TheatreStatus;
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
@Table (name="Theatre")
public class TheatreEntity implements Serializable {
  @Id 
  private String theatreId;
  @Column(nullable = false)
  private String theatreName;
  @Column(nullable = false)
  private String location;
  @Column(nullable = false)
  private Integer capacity;
  @Enumerated(EnumType.STRING)
  private TheatreStatus status;

  //theatre-show
  @OneToMany (mappedBy = "Theatre")
   private List<ShowEntity> Show;

}

