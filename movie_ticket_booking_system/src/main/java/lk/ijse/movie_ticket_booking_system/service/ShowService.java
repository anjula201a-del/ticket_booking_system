package lk.ijse.movie_ticket_booking_system.service;

import java.util.List;

import lk.ijse.movie_ticket_booking_system.dto.ShowDTO;


public interface ShowService {
    void createShow(ShowDTO show);
    ShowDTO getSelectedShow(String theatreId);
    List<ShowDTO> getAllShows();
    void updateShow(String showId,ShowDTO show);
    void deleteShow(String showId);

}
