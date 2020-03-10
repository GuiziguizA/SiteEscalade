package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;

import javax.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;

import sig.org.dao.VoieRepository;
@Service
@Transactional
public class VoieMetier implements Ivoie{
@Autowired
	private VoieRepository voieRepository;
@PersistenceContext
private EntityManager em;
	

EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.baeldung.movie__catalog");




public VoieMetier () {

	
	em=emf.createEntityManager();
	
	
}
	@Override	
	public Voie createOrUpdateVoie(Voie entity) throws RecordTypeNotSupportedException {
		
		Optional<Voie> voie =voieRepository.findById(entity.getCodeVoie()); 
		 if( voie.isPresent()) { 
			Voie  newEntity = voie.get();
			newEntity.setCotation(entity.getCotation());
           newEntity.setLongueur(entity.getLongueur());
           newEntity.setNom(entity.getNom());;
           newEntity.setSite(entity.getSite());
           
           return newEntity;
	        } else {
	            entity =voieRepository.save(entity);
	             
	            return entity;
	        }
	}

	@Override
	public void deleteVoieById(Long id) throws RelationNotFoundException {
		 Optional<Voie>voie = voieRepository.findById(id);
         
	        if(voie.isPresent()) 
	        {
	        	voieRepository.deleteById(id);
	        } else {
	            throw new RelationNotFoundException("No voie record exist for given id");
	        }
	    } 	
	
		
	

	@Override
	public Voie  getVoieById(Long id) throws RelationNotFoundException {
	    Optional<Voie> voie = voieRepository.findById(id);
        
        if(voie.isPresent()) {
            return voie.get();
        } else {
            throw new RelationNotFoundException("No voie record exist for given id");
        }

	}

	@Override
    public List<Voie> getAllVoie()
    {
        List<Voie> toposList = (List<Voie>) voieRepository.findAll();
         
        if(toposList.size() > 0) {
            return toposList;
        } else {
            return new ArrayList<Voie>();
        }
    }
	
@Override

	 public   List<Voie> getVoieCritere(String name, String cotation) {
			
	 TypedQuery<Voie> query=em.createQuery("from Voie c where ((:name is null and c.name is null) or c.name = :name) and c.cotation =:cotation",Voie.class)
			 .setParameter("name", name)
			 .setParameter("cotation", cotation);
	 List<Voie> results = query.getResultList();
return results;
}

}