package net.najiboulhouch.gestionpersonnel.respositories;

import net.najiboulhouch.gestionpersonnel.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T , Long> {

}
