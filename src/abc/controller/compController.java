package abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import abc.Dao.ComplainDao;

import abc.Vo.ComplainVo;

@Controller
public class compController {
	@Autowired ComplainDao dao;
	
	@RequestMapping(value="/complain.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		
		return new ModelAndView("USER/Complain","Complain",new ComplainVo());
	}
	
	@RequestMapping(value="/viewComplain.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls = this.dao.search();
		
		return new ModelAndView("ADMIN/viewComplain","complainList",ls);
	}
	@RequestMapping(value="/insertComplain.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute ComplainVo vo)
	{
		this.dao.insert(vo);
		return new ModelAndView("redirect:complain.htm");
	}

}
