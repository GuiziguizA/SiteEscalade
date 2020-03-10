package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Commentaires;
import sig.org.classe.Topos;


public interface Itopos {

	

	

	public Topos createOrUpdateTopos(Topos entity) throws RecordTypeNotSupportedException;

	public void deleteToposById(Long id) throws RelationNotFoundException;

	public Topos getToposById(Long id) throws RelationNotFoundException;

	public List<Topos> getAllTopos();
}
