package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Tague;

public interface Itague {

	public Tague createOrUpdateTague(Tague entity) throws RecordTypeNotSupportedException;

	public void deleteTagueById(Long id) throws RelationNotFoundException;

	public List<Tague> getAllTague();

	public Tague getTagueById(Long id) throws RelationNotFoundException;

}
