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

import lk.ijse.movie_ticket_booking_system.dto.ShowDTO;
import lk.ijse.movie_ticket_booking_system.service.ShowService;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/shows")
@RestController 
@RequiredArgsConstructor 
public class ShowController {

    private final ShowService showService;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createShow(@RequestBody ShowDTO showDTO) {
        logger.info("Incoming create show detail is {}", showDTO);
        showService.createShow(showDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{showId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowDTO> getSelectedShow(@PathVariable String showId) {
        return new ResponseEntity<>(showService.getSelectedShow(showId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShowDTO>> getShows() {
        return new ResponseEntity<>(showService.getAllShows(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{showId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateShow(@PathVariable String showId, @RequestBody ShowDTO showDTO) {
        showService.updateShow(showId, showDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{showId}")
    public ResponseEntity<Void> deleteShow(@PathVariable String showId) {
        showService.deleteShow(showId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
