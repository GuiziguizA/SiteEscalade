package sig.org.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;

import sig.org.classe.Commentaires;
import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.classe.Voie;

public interface IEscalade {
	
	 	 public Page<Voie> listVoie(Long codeSiteEscalade,int page ,int size);
	 	 public  Page<SiteEscalade> ListSite(Long codeSiteEscalade, int page, int size);
	 	 public void createUtilisateur(String nom, String mail);
	 	 public void createVoie( String nom, String longueur, String cotation,SiteEscalade site);
	 	 public void updateVoie (String nom,  String longueur, String cotation,  Long codeVoie);
	 	 public void DeleteVoie (Long codeVoie);
	 	 public Voie readVoie (Long codeSiteEscalade, Long codeUtilisateur,Long codeVoie);
	 	 
	 	 public void createCommentaire(Utilisateur utilisateur, Date date, String description);
	 	 public void updateCommentaire(Long codeCommentaire, String description, Date date);
	 	 public Commentaires readCommentaire(Long codeSiteEscalade, Long codeUtilisateur, Long codeCommentaire);
	 	 public void deleteCommentaire(Long codeSiteEscalade, Long codeUtilisateur, Long codeCommentaire);
	 	 
	 	 public void updateStatutSiteEscalade(Long codeSiteEscalade, String statut);
	 	 
	 	 public void createTopos(Long codeTopos, String nom, String description, String dateDeParuption,
					Utilisateur utilisateur, String statut, Region region);
	 	 public void updateTopos(Long codeTopos,String nom, String description, String dateDeParuption, Utilisateur utilisateur, String statut,
	 			Region region);
	 	 public Topos readTopos(Long codeSiteEscalade, Long codeUtilisateur,Long codeTopos);
	 	 public void deleteTopos(Long codeSiteEscalade, Long codeUtilisateur,Long codeTopos);
	 	 
	 	 public Page<Topos> listTopos(Long codeSiteEscalade);
	 	
	 	
		public void updateStatutTopos(Long codeTopos, String statut);
		
		
		
		
		
	
}
