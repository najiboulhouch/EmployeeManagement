package net.najiboulhouch.gestionpersonnel.services;

import net.najiboulhouch.gestionpersonnel.entities.BaseEntity;
import net.najiboulhouch.gestionpersonnel.exceptions.ErrorMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaseService<T extends BaseEntity> {

        /**
         *
         * @return List
         */
        public Page<T> findAll(Pageable pageable);

        /**
         *
         * @param id
         * @return Entity
         */
        public Optional<T> findById(Long id);

        /**
         *
         * @param entity
         * @throws ErrorMessage
         */
        public T save(T entity) ;

        /**
         *
         * @param entities
         * @throws ErrorMessage
         */
        public void save(List<T> entities);

        /**
         *
         * @param entity
         * @throws ErrorMessage
         */
        public void delete(T entity);

        /**
         *
         * @param entities
         */
        public void delete(List<T> entities);

    }
