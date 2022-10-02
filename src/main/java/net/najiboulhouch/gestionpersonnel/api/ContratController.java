package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.Contrat;
import org.springframework.web.bind.annotation.*;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 */

@RestController
@RequestMapping(path = "api/v1/contrats")
public class ContratController extends BaseController<Contrat>  {



}
