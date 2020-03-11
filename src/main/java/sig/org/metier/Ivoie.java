package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;


import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Voie;

public interface Ivoie {

	public Voie createOrUpdateVoie(Voie entity) throws RecordTypeNotSupportedException;

	public void deleteVoieById(Long id) throws RelationNotFoundException;

	Voie getVoieById(Long id) throws RelationNotFoundException;

	public List<Voie> getAllVoie();

	 public   List<Voie> getVoieCritere(String name, String cotation);

	/*
	 * public Specification<Voie> withCotation(String cotation);
	 * 
	 * public Specification<Voie> withlongueur(String longueur);
	 * 
	 * public Specification<Voie> withSite(SiteEscalade site);
	 */

}
