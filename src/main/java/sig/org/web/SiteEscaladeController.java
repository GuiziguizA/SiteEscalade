package sig.org.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sig.org.metier.ISiteEscalade;



@Controller
public class SiteEscaladeController {
@Autowired
private ISiteEscalade siteEscalade;
	@RequestMapping("/site")
	public String index() {
		return "siteEscalade";
	}
}
