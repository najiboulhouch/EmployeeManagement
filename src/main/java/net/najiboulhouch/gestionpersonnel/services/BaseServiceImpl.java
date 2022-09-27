package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.BaseEntity;
import net.najiboulhouch.gestionpersonnel.respositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private BaseRepository<T> reporitory ;


    @Override
    public Page<T> findAll(Pageable pageable) {
        return reporitory.findAll(pageable);
    }


    @Override
    public T save(T entity)  {
       return reporitory.save(entity);
    }

    @Override
    public void delete(T entity)  {
        reporitory.delete(entity);
    }

    @Override
    public void save(List<T> entities){
        for (T entity : entities) {
            this.save(entity);
        }
    }

    @Override
    public void delete(List<T> entities) {
        for (T entity : entities) {
            this.delete(entity);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        return reporitory.findById(id);
    }
}
