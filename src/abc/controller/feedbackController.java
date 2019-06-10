package abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.ComplainDao;
import abc.Dao.FeedbackDao;
import abc.Vo.FeedbackVo;

@Controller

public class feedbackController {
	@Autowired FeedbackDao dao;
	
	@RequestMapping(value="/feedback.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		
		return new ModelAndView("USER/Feedback","feedback",new FeedbackVo());
	}
	
	@RequestMapping(value="/viewFeedback.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls = this.dao.search();
		
		return new ModelAndView("ADMIN/viewFeedback","feedbackList",ls);
	}
	@RequestMapping(value="/insertFeedback.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute FeedbackVo vo)
	{
		this.dao.insert(vo);
		return new ModelAndView("redirect:addFeedback.htm");
	}
}
