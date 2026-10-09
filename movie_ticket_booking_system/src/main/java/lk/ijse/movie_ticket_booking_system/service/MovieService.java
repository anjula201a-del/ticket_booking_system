package lk.ijse.movie_ticket_booking_system.service;

import java.util.List;

import lk.ijse.movie_ticket_booking_system.dto.MovieDTO;


public interface MovieService {
    void createMovie(MovieDTO movie);
    MovieDTO getSelectedMovie(String movieId);
    List<MovieDTO> getAllMovies();
    void updateMovie(String movieId,MovieDTO movie);
    void deleteMovie(String movieId);

}
