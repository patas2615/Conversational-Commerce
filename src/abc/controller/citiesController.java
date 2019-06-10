package abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.CityDao;
import abc.Vo.BrandVo;
import abc.Vo.CityVo;

@Controller

public class citiesController {
	@Autowired CityDao dao;
	@RequestMapping(value="/addCity.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		return new ModelAndView("ADMIN/addCity","City",new CityVo());
	}
	
	@RequestMapping(value="/viewCity.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls=this.dao.search();
		return new ModelAndView("ADMIN/viewCity","cityList",ls);
	}
	@RequestMapping(value="/insertCity.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute CityVo vo)
	{
		this.dao.insert(vo);
		return new ModelAndView("redirect:addCity.htm");
	}
	@RequestMapping(value="/deleteCity.htm",method=RequestMethod.GET)
	public ModelAndView delete(CityVo vo,@RequestParam("id")int id)
	{
		vo.setCityId(id);
		this.dao.delete(vo);
		return new ModelAndView("redirect:viewCity.htm");
	}
	@RequestMapping(value="/editCity.htm",method=RequestMethod.GET)
	public ModelAndView Edit(@RequestParam("id")int id,CityVo vo)
	{
		vo.setCityId(id);
		List ls = this.dao.edit(vo);
		
		return new ModelAndView("ADMIN/editCity","City",(CityVo)ls.get(0));
	}
	@RequestMapping(value="/updateCity.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute CityVo vo)
	{
		this.dao.update(vo);
		return new ModelAndView("redirect:viewCity.htm");
	}
}
