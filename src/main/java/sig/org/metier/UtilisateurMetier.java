package sig.org.metier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;

public class UtilisateurMetier implements Iutilisateur {
	
	
@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur createOrUpdateUtilisateur(Utilisateur entity )throws RecordTypeNotSupportedException { 
		Optional<Utilisateur> utilisateur =utilisateurRepository.findById(entity.getCodeUtilisateur()); 
		 if(utilisateur.isPresent()) { 
			Utilisateur  newEntity = utilisateur.get();
			newEntity.setMail(entity.getMail());
            newEntity.setNom(entity.getNom());
            newEntity.setPasseword(entity.getPasseword());
            newEntity = utilisateurRepository.save(newEntity);    
            return newEntity;
	        } else {
	            entity =utilisateurRepository.save(entity);
	             
	            return entity;
	        }
	}
}
