package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.Payment;
import net.najiboulhouch.gestionpersonnel.respositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment> implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository  ;
}
