package lk.ijse.movie_ticket_booking_system.service.impl;

import lk.ijse.movie_ticket_booking_system.DAO.PaymentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.Entity.PaymentEntity;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.dto.PaymentDTO;
import lk.ijse.movie_ticket_booking_system.service.PaymentService;
import lk.ijse.movie_ticket_booking_system.util.Conversion;
import lk.ijse.movie_ticket_booking_system.util.IDGenerate;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
@Transactional 
public class PaymentServiceIMPL implements PaymentService{
      private final PaymentDao paymentDao;
      private final Conversion conversion;



      @Override
    public void createPayment(PaymentDTO payment) {
        payment.setPaymentId(IDGenerate.paymentId());
       paymentDao.save(conversion.toPaymentEntity(payment));

        
    }

    
     @Override
    public PaymentDTO getSelectedPayment(String paymentId) {
    PaymentEntity paymentEntity= paymentDao.findById(paymentId)
                               .orElseThrow(()-> new DataNotFoundException("payment not found") );
        return conversion.toPaymentDTO(paymentEntity);
                                
    }

}
