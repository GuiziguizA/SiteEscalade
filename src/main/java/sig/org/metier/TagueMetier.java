package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Tague;
import sig.org.classe.Voie;
import sig.org.dao.TagueRepository;
import sig.org.dao.VoieRepository;

public class TagueMetier implements Itague{
	@Autowired
	private TagueRepository tagueRepository;
	
	@Override
	public Tague createOrUpdateTague(Tague entity) throws RecordTypeNotSupportedException {
		Optional<Tague> tague =tagueRepository.findById(entity.getCodeTague()); 
		 if( tague.isPresent()) { 
			Tague  newEntity = tague.get();
			newEntity.setSite(entity.getSite());;
           newEntity.setStatut(entity.getStatut());
           newEntity.setUtilisateur(entity.getUtilisateur());
           
           
           return newEntity;
	        } else {
	            entity =tagueRepository.save(entity);
	             
	            return entity;
	        }
	}

	@Override
	public void deleteTagueById(Long id) throws RelationNotFoundException {
		 Optional<Tague>tague = tagueRepository.findById(id);
         
	        if(tague.isPresent()) 
	        {
	        	tagueRepository.deleteById(id);
	        } else {
	            throw new RelationNotFoundException("No voie record exist for given id");
	        }
	    } 	
	
		
	

	@Override
	public Tague  getTagueById(Long id) throws RelationNotFoundException {
	    Optional<Tague> tague = tagueRepository.findById(id);
        
        if(tague.isPresent()) {
            return tague.get();
        } else {
            throw new RelationNotFoundException("No tague record exist for given id");
        }

	}

	@Override
    public List<Tague> getAllTague()
    {
        List<Tague> tagueList = tagueRepository.findAll();
         
        if(tagueList.size() > 0) {
            return tagueList;
        } else {
            return new ArrayList<Tague>();
        }
    }
}
