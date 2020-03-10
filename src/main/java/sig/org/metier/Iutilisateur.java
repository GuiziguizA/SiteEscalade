package sig.org.metier;

import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Utilisateur;

public interface Iutilisateur {

	public Utilisateur createOrUpdateUtilisateur(Utilisateur entity) throws RecordTypeNotSupportedException;

}
