package sig.org.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToposController {
	@RequestMapping("/topos")
	public String index() {
		return "topos";
}
}