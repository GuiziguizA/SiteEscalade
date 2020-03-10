package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Commentaires;

public interface Icommentaire {

	public Commentaires createOrUpdateCommentaire(Commentaires entity) throws RecordTypeNotSupportedException;

	public void deleteCommentaireById(Long id) throws  RelationNotFoundException;

	public Commentaires getCommentaireById(Long id) throws RelationNotFoundException;

	public List<Commentaires> getAllCommentaire();

}
