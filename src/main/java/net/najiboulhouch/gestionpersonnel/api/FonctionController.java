package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.Fonction;
import net.najiboulhouch.gestionpersonnel.exceptions.ResourceNotFoundException;
import net.najiboulhouch.gestionpersonnel.services.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 */

@RestController
@RequestMapping(path = "api/v1/fonctions")
public class FonctionController extends BaseController<Fonction> {

    @Autowired
    private FonctionService fonctionService ;


    @GetMapping("/fonctionsForList")
    public ResponseEntity<List<Fonction>> getAllFonctionsForSelect() {
        List<Fonction> fonctions = fonctionService.findAllFonctions();
        return new ResponseEntity<>(fonctions , HttpStatus.OK );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fonction> updateFonction(@PathVariable(value = "id") Long fonctionId ,
                                                   @Valid @RequestBody Fonction fonctionDetails) throws ResourceNotFoundException {

        Fonction fonction = getEntity(fonctionId , "Fonction not found for this id :: ");

        fonction.setLabel(fonctionDetails.getLabel());
        fonction.setDescription(fonctionDetails.getDescription());
        final Fonction updateFonction  = fonctionService.save(fonction);
        return ResponseEntity.ok(updateFonction);
    }
}
