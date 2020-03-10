package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Commentaires;

import sig.org.dao.CommentaireRepository;

public class CommentaireMetier implements Icommentaire {

	@Autowired
	private CommentaireRepository commentaireRepository;
	

	@Override
    public List<Commentaires> getAllCommentaire()
    {
        List<Commentaires> commentaireList = commentaireRepository.findAll();
         
        if(commentaireList.size() > 0) {
            return commentaireList;
        } else {
            return new ArrayList<Commentaires>();
        }
    }
    @Override
    public Commentaires getCommentaireById(Long id) throws RelationNotFoundException {
        Optional<Commentaires> commentaire = commentaireRepository.findById(id);
         
        if(commentaire.isPresent()) {
            return commentaire.get();
        } else {
            throw new RelationNotFoundException("No commentaire record exist for given id");
        }
    }
	
	
	@Override
	public Commentaires createOrUpdateCommentaire(Commentaires entity  )throws RecordTypeNotSupportedException { 
		Optional<Commentaires> commentaire =commentaireRepository.findById(entity.getCodeCommentaire()); 
		 if( commentaire.isPresent()) { 
			Commentaires  newEntity =  commentaire.get();
			newEntity.setDescription(entity.getDescription());
            newEntity.setDate(entity.getDate());
            newEntity.setUtilisateur(entity.getUtilisateur());
          
            return newEntity;
	        } else {
	            entity =commentaireRepository.save(entity);
	             
	            return entity;
	        }
	}
	

	@Override
	  public void deleteCommentaireById(Long id) throws RelationNotFoundException   {
	        Optional<Commentaires>commentaire = commentaireRepository.findById(id);
	         
	        if(commentaire.isPresent()) 
	        {
	        	commentaireRepository.deleteById(id);
	        } else {
	            throw new RelationNotFoundException("No commentaire record exist for given id");
	        }
	    } 	
	
	
}
