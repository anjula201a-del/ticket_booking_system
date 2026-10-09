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

import lk.ijse.movie_ticket_booking_system.dto.TheatreDTO;
import lk.ijse.movie_ticket_booking_system.service.TheatreService;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/theatres")
@RestController 
@RequiredArgsConstructor 
public class TheatreController {

    private final TheatreService theatreService;
    private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTheatre(@RequestBody TheatreDTO theatreDTO) {
        logger.info("Incoming create theatre detail is {}", theatreDTO);
        theatreService.createTheatre(theatreDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{theatreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TheatreDTO> getSelectedTheatre(@PathVariable String theatreId) {
        return new ResponseEntity<>(theatreService.getSelectedTheatre(theatreId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TheatreDTO>> getTheatres() {
        return new ResponseEntity<>(theatreService.getAllTheatres(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{theatreId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateTheatre(@PathVariable String theatreId, @RequestBody TheatreDTO theatreDTO) {
        theatreService.updateTheatre(theatreId, theatreDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{theatreId}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable String theatreId) {
        theatreService.deleteTheatre(theatreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}