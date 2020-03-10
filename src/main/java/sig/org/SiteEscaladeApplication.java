package sig.org;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;

import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;
import sig.org.classe.Voie;
import sig.org.dao.RegionRepository;
import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.UtilisateurRepository;
import sig.org.dao.VoieRepository;
import sig.org.metier.IEscalade;
import sig.org.metier.Ivoie;




@SpringBootApplication
public class SiteEscaladeApplication implements CommandLineRunner{
@Autowired
private IEscalade scalade;
@Autowired
private RegionRepository regionRepository;
@Autowired
private SiteEscaladeRepository siteEscaladeRepository;
@Autowired
private Ivoie voieMetier;
@Autowired
private VoieRepository voieRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiteEscaladeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	scalade.createUtilisateur("boobo","Paul","paulux@gmail.com");
		scalade.createUtilisateur("bobobob","le man", "leMan@gmail.com");
		*/
		
		Region lyon = regionRepository.save(new Region( "Lyon"));
		Region paris = regionRepository.save(new Region( "Paris"));
		SiteEscalade puit = siteEscaladeRepository.save(new SiteEscalade("le camp des ecureil","23 rue de la belette","69000", "agreable comporte 4 voie", lyon, "une etoile"));
		SiteEscalade peto = siteEscaladeRepository.save(new SiteEscalade("le camp des bon client","23 rue de la belos","75000", "agreable comporte 4 voie", paris, "une etoile"));
		Voie v2= new Voie("v2","+++++", "4b", puit);
		Voie v4= new Voie("v4","+++++", "4b", puit);
		Voie v3= new Voie("v3","+++++", "4b", peto);
		Voie v1= new Voie("v1","+++", "4b", peto);
		/*
		 * voieMetier.createOrUpdateVoie(v2); voieMetier.createOrUpdateVoie(v1);
		 * voieMetier.createOrUpdateVoie(v3); voieMetier.createOrUpdateVoie(v4);
		 */
		
		
		
		
		/*
		 * Specification<Voie> spec = Specification .where(voieMetier.withlongueur("6"))
		 * .and(voieMetier.withSite(puit)).and(voieMetier.withCotation("ert"));
		 */

	
		
	}

}
