package abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.BrandDao;
import abc.Vo.BrandVo;
import abc.Vo.CategoryVo;
@Controller

public class brandController {
	@Autowired BrandDao dao;
	@RequestMapping(value="/addBrand.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		return new ModelAndView("ADMIN/addBrand","Brand",new BrandVo());
	}
	
	@RequestMapping(value="/viewBrand.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls=this.dao.search();
		return new ModelAndView("ADMIN/viewBrand","brandList",ls);
	}
	@RequestMapping(value="/insertBrand.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute BrandVo vo)
	{
		this.dao.insert(vo);
		return new ModelAndView("redirect:addBrand.htm");
	}
	@RequestMapping(value="/deleteBrand.htm",method=RequestMethod.GET)
	public ModelAndView delete(BrandVo vo,@RequestParam("id")int id)
	{
		vo.setBrandId(id);
		this.dao.delete(vo);
		return new ModelAndView("redirect:viewBrand.htm");
	}
	@RequestMapping(value="/editBrand.htm",method=RequestMethod.GET)
	public ModelAndView Edit(@RequestParam("id")int id,BrandVo vo)
	{
		vo.setBrandId(id);
		List ls = this.dao.edit(vo);
		
		return new ModelAndView("ADMIN/editBrand","Brand",(BrandVo)ls.get(0));
	}
	@RequestMapping(value="/updateBrand.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute BrandVo vo)
	{
		this.dao.update(vo);
		return new ModelAndView("redirect:viewBrand.htm");
	}
}
