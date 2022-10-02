package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.Absence;
import net.najiboulhouch.gestionpersonnel.entities.Payment;
import net.najiboulhouch.gestionpersonnel.exceptions.ResourceNotFoundException;
import net.najiboulhouch.gestionpersonnel.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 */

@RestController
@RequestMapping(path = "api/v1/payments")
public class PayementController extends BaseController<Payment> {

    @Autowired
    private PaymentService paymentService ;



    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") Long paymentId ,
                                                   @Valid @RequestBody Payment paymentSend) throws ResourceNotFoundException {

        Payment payment = getEntity(paymentId , "payment not found for this id ");
        payment.setSalaire(paymentSend.getSalaire());

        final Payment updatePayment  = paymentService.save(payment);
        return ResponseEntity.ok(updatePayment);
    }

}
