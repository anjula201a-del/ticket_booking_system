package lk.ijse.movie_ticket_booking_system.service;

import java.util.List;
import lk.ijse.movie_ticket_booking_system.dto.TheatreDTO;

public interface TheatreService {   
    void createTheatre(TheatreDTO theatre);
    TheatreDTO getSelectedTheatre(String theatreId);
    List<TheatreDTO> getAllTheatres();
    void updateTheatre(String theatreId,TheatreDTO theatre);
    void deleteTheatre(String theatreId);
}
