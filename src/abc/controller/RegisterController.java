package abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import abc.Dao.RegisterDao;
import abc.Vo.LoginVo;
import abc.Vo.RegisterVo;

@Controller
public class RegisterController {
	@Autowired RegisterDao dao;
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		return new ModelAndView("USER/Register","register",new RegisterVo());
	}
	
	@RequestMapping(value="/insertRegister.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute RegisterVo vo,LoginVo lvo)
	{
		String un=vo.getLvo().getUsername();
		String pw=vo.getLvo().getPassword();
		lvo.setUsername(un);
		lvo.setPassword(pw);
		lvo.setRole("ROLE_USER");
		lvo.setEnabled("1");
		this.dao.Logininsert(lvo);
		vo.setLvo(lvo);
		this.dao.insert(vo);
		return new ModelAndView("redirect:login.htm");
	}
}
