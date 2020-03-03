package sig.org.metier;



import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Commentaires;
import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.classe.Voie;
import sig.org.dao.CommentaireRepository;
import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.ToposRepository;
import sig.org.dao.UtilisateurRepository;
import sig.org.dao.VoieRepository;
@Service
@Transactional
public class EscaladeMetier implements IEscalade{

	@Autowired
	private VoieRepository voieRepository;
	@Autowired 
	private SiteEscaladeRepository  siteEscaladeRepository;
	@Autowired 
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private ToposRepository toposRepository;

	
	
	@Override
	public Page<Voie> listVoie(Long codeSiteEscalade,  int page , int size) {
	
		return  voieRepository.listeVoiesDunSiteEscalade(codeSiteEscalade, PageRequest.of(page, size));
	}

	@Override
	public Page<SiteEscalade> ListSite(Long codeSiteEscalade, int page , int size){
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public void createUtilisateur(String nom , String mail) {
		utilisateurRepository.save(new Utilisateur(nom, mail));
		
		
	}

	
	@Override
	public void createCommentaire(Utilisateur utilisateur,Date date,String description) {
		commentaireRepository.save(new Commentaires(utilisateur, date, description));
		
	}

	@Override
	public void updateStatutSiteEscalade(Long codeSiteEscalade, String statut) {
		SiteEscalade s= siteEscaladeRepository.findById(codeSiteEscalade)
				.orElseThrow(()-> new EntityNotFoundException("Site d'escalade introuvable"));
		s.setStatut(statut);
		siteEscaladeRepository.save(s);
	}

	@Override
	public void createTopos(Long codeTopos,String nom, String description, String dateDeParuption, Utilisateur utilisateur, String statut,
			Region region) {
		toposRepository.save(new Topos(codeTopos,nom, description, dateDeParuption,  utilisateur, statut,
		region));
		
	}

	@Override
	public Page<Topos> listTopos(Long codeSiteEscalade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatutTopos(Long codeTopos, String statut) {
		Topos t= toposRepository.findById(codeTopos)
				.orElseThrow(()-> new EntityNotFoundException("Topos introuvable"));
		t.setStatut(statut);
	}

	
	
	@Override
	public void createVoie(String nom,String longueur,String cotation,SiteEscalade site) {
		// TODO Auto-generated method stub
		voieRepository.save(new Voie(nom,longueur, cotation,site));

	}

	@Override
	public void updateVoie(String nom,  String longueur, String cotation,  Long codeVoie) {
		Voie v= voieRepository.findById(codeVoie)
				.orElseThrow(()-> new EntityNotFoundException("Voie introuvable"));

		v.setNom(nom);
		v.setLongueur(longueur);
		v.setCotation(cotation);
		voieRepository.save(v);
	}

	@Override
	public void DeleteVoie(Long codeVoie) {
		voieRepository.deleteById(codeVoie);		
	}

	@Override
	public Voie readVoie(Long codeSiteEscalade, Long codeUtilisateur, Long codeVoie) {
		Voie v= voieRepository.findById(codeVoie)
				.orElseThrow(()-> new EntityNotFoundException("Voie introuvable"));
	return v;
	
			}

	@Override
	public void updateCommentaire(Long codeCommentaire,String description,Date date ) {
		Commentaires c= commentaireRepository.findById(codeCommentaire)
				.orElseThrow(()-> new EntityNotFoundException("Voie introuvable"));
		c.setDate(date);
		c.setDescription(description);
		commentaireRepository.save(c);
	}

	@Override
	public Commentaires readCommentaire(Long codeSiteEscalade, Long codeUtilisateur, Long codeCommentaire) {
		Commentaires c= commentaireRepository.findById(codeCommentaire)
				.orElseThrow(()-> new EntityNotFoundException("Voie introuvable"));
		return c;
	}

	@Override
	public void deleteCommentaire(Long codeSiteEscalade, Long codeUtilisateur, Long codeCommentaire) {
	
		commentaireRepository.deleteById(codeCommentaire);		
	}

	@Override
	public void updateTopos(Long codeTopos,String nom, String description, String dateDeParuption, Utilisateur utilisateur, String statut,
			Region region) {
		Topos t= toposRepository.findById(codeTopos)
				.orElseThrow(()-> new EntityNotFoundException("Topos introuvable"));
		t.setDateDeParuption(dateDeParuption);
		t.setDescription(description);
		t.setNom(nom);
		t.setRegion(region);
		t.setStatut(statut);
		t.setUtilisateur(utilisateur);
		toposRepository.save(t);
		
	}

	@Override
	public Topos readTopos(Long codeSiteEscalade, Long codeUtilisateur, Long codeTopos) {
		Topos t= toposRepository.findById(codeTopos)
				.orElseThrow(()-> new EntityNotFoundException("Topos introuvable"));
		return t;
	}

	@Override
	public void deleteTopos(Long codeSiteEscalade, Long codeUtilisateur, Long codeTopos) {
		toposRepository.deleteById(codeTopos);	
		
	}

	

}
