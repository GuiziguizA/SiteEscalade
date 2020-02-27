package sig.org.metier;

import org.springframework.data.domain.Page;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Topos;
import sig.org.classe.Voie;

public interface IEscalade {
	
	 	 public Page<Voie> listVoie(Long codeSiteEscalade);
	 	 public  Page<SiteEscalade>ListSite(String longueur,String cotation);
	 	 public void createCompte();
	 	 public void createVoie(Long codeSiteEscalade, Long codeUtilisateur);
	 	 public void createCommentaire(Long codeSiteEscalade, Long codeUtilisateur);
	 	 public void updateStatutSiteEscalade(Long codeUtilisateur,Long codeSiteEscalade);
	 	 public void createTopos(Long codeSiteEscalade, Long codeUtilisateur);
	 	 public Page<Topos> listTopos(Long codeSiteEscalade);
	 	 public void demandeReservationTopos(Long CodeTopos, Long codeUtilisateur);
	 	 public void validerReservationTopos(Long CodeTopos, Long codeUtilisateur);
}
