package lk.ijse.movie_ticket_booking_system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.movie_ticket_booking_system.dto.MovieDTO;
import lk.ijse.movie_ticket_booking_system.service.MovieService;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/movies")
@RestController 
@RequiredArgsConstructor 
public class MovieController {

    private final MovieService movieService;
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createMovie(@RequestBody MovieDTO movieDTO) {
        logger.info("Incoming create movie detail is {}", movieDTO);
        movieService.createMovie(movieDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> getSelectedMovie(@PathVariable String movieId) {
        return new ResponseEntity<>(movieService.getSelectedMovie(movieId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDTO>> getMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMovie(@PathVariable String movieId, @RequestBody MovieDTO movieDTO) {
        movieService.updateMovie(movieId, movieDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}