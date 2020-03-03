package sig.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sig.org.classe.Commentaires;

public interface CommentaireRepository extends JpaRepository<Commentaires, Long>{

}
