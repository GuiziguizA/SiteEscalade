package sig.org.classe;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Utilisateur implements Serializable{
@Id @GeneratedValue
private Long codeUtilisateur;
	private String nom;
	
	private String password;
	@Column(unique =true )
	private String mail;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Tague> tagues;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
private Collection<Commentaires> commentaires;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String mail) {
		super();
		this.nom = nom;
		this.mail = mail;
	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Collection<Tague> getTagues() {
		return tagues;
	}

	public void setTagues(Collection<Tague> tagues) {
		this.tagues = tagues;
	}
	
	
}
