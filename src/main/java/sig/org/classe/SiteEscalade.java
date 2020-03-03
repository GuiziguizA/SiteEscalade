package sig.org.classe;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class SiteEscalade {

	@ Id @GeneratedValue 
	private Long codeSiteEscalade;
	private String adresse ;
	private String codePostal;
	private String commentaire;
	private String statut;
	@ManyToOne
	private Region region;
	@OneToMany(mappedBy="site",fetch=FetchType.LAZY)
	private Collection<Voie> voies;
	@OneToMany(mappedBy="site",fetch=FetchType.LAZY)
	private Collection<Tague> tagues;
	
	
	public SiteEscalade() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SiteEscalade(String adresse, String codePostal, String commentaire, Region region,String statut) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.commentaire = commentaire;
		this.region = region;
		this.statut = statut;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	public Collection<Voie> getVoies() {
		return voies;
	}


	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}


	public Collection<Tague> getTagues() {
		return tagues;
	}


	public void setTagues(Collection<Tague> tagues) {
		this.tagues = tagues;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	
	
}
