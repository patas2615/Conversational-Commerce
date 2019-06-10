package abc.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.CategoryDao;
import abc.Vo.CategoryVo;


@Controller

public class categoryController {
	@Autowired CategoryDao dao;
	
	@RequestMapping(value="/addCategory.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		
		return new ModelAndView("ADMIN/addCategory","Category",new CategoryVo());
	}
	
	@RequestMapping(value="/viewCategory.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls = this.dao.search();
		
		return new ModelAndView("ADMIN/viewCategory","categoryList",ls);
	}
	@RequestMapping(value="/insertCategory.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute CategoryVo vo)
	{
		this.dao.insert(vo);
		return new ModelAndView("redirect:addCategory.htm");
	}
	@RequestMapping(value="/deleteCategory.htm",method=RequestMethod.GET)
	public ModelAndView delete(CategoryVo catvo,@RequestParam("id")int id)
	{
		catvo.setCategoryId(id);
		this.dao.delete(catvo);
		return new ModelAndView("redirect:viewCategory.htm");
	}
	@RequestMapping(value="/editCategory.htm",method=RequestMethod.GET)
	public ModelAndView Edit(@RequestParam("id")int id,CategoryVo catvo)
	{
		catvo.setCategoryId(id);
		List ls = this.dao.edit(catvo);
		
		return new ModelAndView("ADMIN/editCategory","Category",(CategoryVo)ls.get(0));
	}
	@RequestMapping(value="/updateCategory.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute CategoryVo vo)
	{
		this.dao.update(vo);
		return new ModelAndView("redirect:viewCategory.htm");
	}
	
}

