package lk.ijse.movie_ticket_booking_system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.movie_ticket_booking_system.dto.PaymentDTO;
import lk.ijse.movie_ticket_booking_system.service.PaymentService;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/payments")
@RestController 
@RequiredArgsConstructor 
public class PaymentController {

    private final PaymentService paymentService;
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPayment(@RequestBody PaymentDTO paymentDTO) {
        logger.info("Incoming create payment detail is {}", paymentDTO);
        paymentService.createPayment(paymentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentDTO> getSelectedPayment(@PathVariable String paymentId) {
        return new ResponseEntity<>(paymentService.getSelectedPayment(paymentId), HttpStatus.OK);
    }
}



