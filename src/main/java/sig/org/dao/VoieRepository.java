package sig.org.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sig.org.classe.Voie;

public interface VoieRepository 
extends CrudRepository<Voie, Long>,
JpaSpecificationExecutor<Voie> {
	
}
