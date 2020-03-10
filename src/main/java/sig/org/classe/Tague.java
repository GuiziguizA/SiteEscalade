package sig.org.classe;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

public class Tague {
	@Id  @GeneratedValue
	private Long codeTague;
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="ID_SITE")
	private SiteEscalade site;
	private String statut;
	public Tague() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tague(Long codeTague,Utilisateur utilisateur, SiteEscalade site, String statut) {
		super();
		this.utilisateur = utilisateur;
		this.site = site;
		this.statut = statut;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public SiteEscalade getSite() {
		return site;
	}
	public void setSite(SiteEscalade site) {
		this.site = site;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Long getCodeTague() {
		return codeTague;
	}
	
	
}
