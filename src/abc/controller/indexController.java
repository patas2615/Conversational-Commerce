package abc.controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class indexController {

	@RequestMapping(value="/hello.htm",method=RequestMethod.GET)
	public ModelAndView Hello()
	{
		return new ModelAndView("ADMIN/index");
	}
}