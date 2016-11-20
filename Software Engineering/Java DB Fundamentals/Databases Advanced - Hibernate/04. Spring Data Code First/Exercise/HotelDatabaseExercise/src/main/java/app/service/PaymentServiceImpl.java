package app.service;

import app.domain.Payment;
import app.repositories.PaymentRepository;
import app.service.contracts.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void create(Payment payment) {
        this.paymentRepository.saveAndFlush(payment);
    }
}
