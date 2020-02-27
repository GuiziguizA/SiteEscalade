package sig.org.classe;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity


public class Commentaires implements Serializable{
	
	@Id 
	private String codeCommentaire;
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
private Utilisateur utilisateur;
	@ManyToOne
	private Voie voie;
private Date date;




public Commentaires() {
	super();
	// TODO Auto-generated constructor stub
}



public Commentaires(String codeCommentaire,Utilisateur utilisateur, Date date) {
	super();
	this.utilisateur = utilisateur;
	this.date = date;
	
}



public Utilisateur getUtilisateur() {
	return utilisateur;
}



public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}



public Date getDate() {
	return date;
}



public void setDate(Date date) {
	this.date = date;
}














	

}
