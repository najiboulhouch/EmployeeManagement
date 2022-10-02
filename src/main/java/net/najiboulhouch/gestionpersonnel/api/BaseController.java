package net.najiboulhouch.gestionpersonnel.api;

import net.najiboulhouch.gestionpersonnel.entities.BaseEntity;
import net.najiboulhouch.gestionpersonnel.exceptions.ResourceNotFoundException;
import net.najiboulhouch.gestionpersonnel.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Najib OULHOUCH
 * @version 1.0
 * generic controller contains a necessary methods
 * @param <T>
 */
public abstract class BaseController<T extends BaseEntity> {
    @Autowired
    private BaseService<T> baseService;

    @GetMapping("/")
    public ResponseEntity<Page<T>> getAllRows(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<T> entities = baseService.findAll(request);
        if(entities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities , HttpStatus.OK );
    }

    @PostMapping(value = "/" , produces = MediaType.APPLICATION_JSON_VALUE)
    public T createEntity(@Valid @RequestBody T entity) {
        return baseService.save(entity);
    }

    protected T getEntity(Long id , String message )  {
        T entity  = baseService.findById(id).orElseThrow(() -> new ResourceNotFoundException(message + " = " + id));
        return entity;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<T> getEntityById(@PathVariable(value = "id") Long id)  throws ResourceNotFoundException{
        T entity = getEntity(id , "Entity not found for this id");
        return ResponseEntity.ok().body(entity);
    }


    @DeleteMapping("/{id}")
    public Map<String , Boolean> deleteEntity(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException{
        T entity = getEntity(id , "Entity not found for this id");
        baseService.delete(entity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted" , true);
        return response;
    }


}
