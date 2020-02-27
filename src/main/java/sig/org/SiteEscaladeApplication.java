package sig.org;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;




@SpringBootApplication
public class SiteEscaladeApplication implements CommandLineRunner{
@Autowired
private UtilisateurRepository utilisateurRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(SiteEscaladeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		utilisateurRepository.save(new Utilisateur("Jean", "jean@gmail.com"));
		utilisateurRepository.save(new Utilisateur("Paul", "paul@gmail.com"));
	}



}
