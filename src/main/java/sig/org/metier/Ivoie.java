package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;


import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Voie;

public interface Ivoie {

	

	public void deleteVoieById(Long id) throws RelationNotFoundException, Exception;

	public Voie getVoieById(Long id) throws RelationNotFoundException;

	public List<Voie> getAllVoie();


	public List<Voie> getSiteEscalade(Long codeSiteEscalade)throws Exception;
	public Voie createVoie(String nom, String cotation, String longueur, Long codeSiteEscalade) throws Exception;

	public List<Voie> getVoieCritere(String name, String cotation, String longueur) throws Exception;

	
}
