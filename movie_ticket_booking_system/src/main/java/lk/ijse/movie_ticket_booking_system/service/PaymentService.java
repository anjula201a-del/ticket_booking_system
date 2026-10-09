package lk.ijse.movie_ticket_booking_system.service;


import lk.ijse.movie_ticket_booking_system.dto.PaymentDTO;



public interface PaymentService {
   void createPayment(PaymentDTO payment);
   PaymentDTO getSelectedPayment(String paymentId);
    
}
