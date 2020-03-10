package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Commentaires;
import sig.org.classe.Topos;
import sig.org.dao.ToposRepository;

public class ToposMetier implements Itopos{

	@Autowired
	private ToposRepository toposRepository;
	
	@Override
	public Topos createOrUpdateTopos(Topos entity) throws RecordTypeNotSupportedException {
		Optional<Topos> topos =toposRepository.findById(entity.getCodeTopos()); 
		 if( topos.isPresent()) { 
			Topos  newEntity = topos.get();
			newEntity.setDateDeParuption(entity.getDateDeParuption());
           newEntity.setDescription(entity.getDescription());
           newEntity.setNom(entity.getNom());
           newEntity.setRegion(entity.getRegion());
           newEntity.setStatut(entity.getStatut());
           newEntity.setUtilisateur(entity.getUtilisateur());
           return newEntity;
	        } else {
	            entity =toposRepository.save(entity);
	             
	            return entity;
	        }
	}

	@Override
	public void deleteToposById(Long id) throws RelationNotFoundException {
		 Optional<Topos>topos = toposRepository.findById(id);
         
	        if(topos.isPresent()) 
	        {
	        	toposRepository.deleteById(id);
	        } else {
	            throw new RelationNotFoundException("No commentaire record exist for given id");
	        }
	    } 	
	
		
	

	@Override
	public Topos  getToposById(Long id) throws RelationNotFoundException {
	    Optional<Topos> topos = toposRepository.findById(id);
        
        if(topos.isPresent()) {
            return topos.get();
        } else {
            throw new RelationNotFoundException("No commentaire record exist for given id");
        }

	}

	@Override
    public List<Topos> getAllTopos()
    {
        List<Topos> toposList = toposRepository.findAll();
         
        if(toposList.size() > 0) {
            return toposList;
        } else {
            return new ArrayList<Topos>();
        }
    }
	public Topos updateStatutTopos(Long id, String statut) throws RecordTypeNotSupportedException {
		  Optional<Topos> topos = toposRepository.findById(id);
	        
	        if(topos.isPresent()) {
	        	Topos  newEntity = topos.get();
	        	  newEntity.setStatut(statut);
	        	  return newEntity;
	        } else {
	        	 Topos  entity =topos.get();
		             
		            return entity;
	        }

	}	
}
