package lk.ijse.movie_ticket_booking_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.DAO.MovieDao;
import lk.ijse.movie_ticket_booking_system.Entity.MovieEntity;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.dto.MovieDTO;
import lk.ijse.movie_ticket_booking_system.service.MovieService;
import lk.ijse.movie_ticket_booking_system.util.Conversion;
import lk.ijse.movie_ticket_booking_system.util.IDGenerate;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
@Transactional 
public class MovieServiceIMPL implements MovieService {
    private final MovieDao movieDao;
    private final Conversion conversion;

    @Override
    public void createMovie(MovieDTO movie) {
        movie.setMovieId(IDGenerate.movieId());
       movieDao.save(conversion.toMovieEntity(movie));

        
    }

     @Override
    public MovieDTO getSelectedMovie(String movieId) {
    MovieEntity movieEntity= movieDao.findById(movieId)
                               .orElseThrow(()-> new DataNotFoundException("movie not found") );
        return conversion.toMovieDTO(movieEntity);
                                
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> allMovies =movieDao.findAll();
        return conversion.toMovieDTOList(allMovies);
    }

    @Override
    public void updateMovie(String movieId,MovieDTO movie) {
        MovieEntity foundMovie= movieDao.findById(movieId)
                               .orElseThrow(()-> new DataNotFoundException("movie not found") );
                               foundMovie.setTitle(movie.getTitle());
                               foundMovie.setStatus(movie.getStatus());
                               foundMovie.setDescription(movie.getDescription());
                               foundMovie.setDuration(movie.getDuration());
                               foundMovie.setLanguage(movie.getLanguage());
                               foundMovie.setGenre(movie.getGenre());
                               foundMovie.setReleaseDate(movie.getReleaseDate());
                              
    }

    @Override
    public void deleteMovie(String movieId) {
        MovieEntity foundMovie= movieDao.findById(movieId)
                               .orElseThrow(()-> new DataNotFoundException("movie not found") );
                               movieDao.delete(foundMovie);
    }

}
