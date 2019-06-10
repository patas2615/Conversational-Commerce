package abc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	
	@RequestMapping(value = { "/", "index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("USER/Login");
	}
	
	
	@RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	public String admin(HttpSession session,Model model) {
		
		return "ADMIN/index";
	}
	
	@RequestMapping(value = "/user.htm", method = RequestMethod.GET)
	public String user(HttpSession session,Model model) {
		
		return "USER/Index";
	}
	@RequestMapping(value = "/403page.htm", method = RequestMethod.GET)
	public String AccessDenied(HttpSession session,Model model) {
		
		return "USER/Login";
	}
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String Logout(HttpSession session,Model model) {
		
		return "USER/Login";
	}
	
}
