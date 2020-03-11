package sig.org.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageConnexionController {
	@RequestMapping("/connexion")
	public String index() {
		return "pageConnexion";
}
}