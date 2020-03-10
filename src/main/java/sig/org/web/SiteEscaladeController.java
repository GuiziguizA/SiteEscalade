package sig.org.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import sig.org.metier.IsiteEscalade;
import sig.org.metier.SiteEscaladeMetier;

@Controller
public class SiteEscaladeController {

	@Autowired
	private IsiteEscalade siteEscalade;
	@RequestMapping("/site")
	public String index() {
		return "siteEscalade";
	}
}
