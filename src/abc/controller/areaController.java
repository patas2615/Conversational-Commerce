package abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.AreaDao;
import abc.Dao.CityDao;
import abc.Vo.AreaVo;
import abc.Vo.SubCategoryVo;

@Controller
public class areaController {
	@Autowired CityDao dao;
	@Autowired AreaDao dao1;
	
	@RequestMapping(value="/addArea.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		List ls = this.dao.search();
		return new ModelAndView("ADMIN/addArea","area",new AreaVo()).addObject("cityList",ls);
	}
	
	@RequestMapping(value="/viewArea.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls1= this.dao1.search();
		return new ModelAndView("ADMIN/viewArea","arealist",ls1);
	}
	@RequestMapping(value="/insertArea.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute AreaVo vo)
	{
		this.dao1.insert(vo);
		return new ModelAndView("redirect:addArea.htm");
	}
	@RequestMapping(value="/deleteArea.htm",method=RequestMethod.GET)
	public ModelAndView delete(AreaVo vo,@RequestParam("id")int id)
	{
		vo.setAreaId(id);
		this.dao1.delete(vo);
		return new ModelAndView("redirect:viewArea.htm");
		
	}
	@RequestMapping(value="/editArea.htm",method=RequestMethod.GET)
	public ModelAndView Edit(@RequestParam("id")int id,AreaVo vo)
	{
		vo.setAreaId(id);
		List ls1 = this.dao1.edit(vo);
		List ls = this.dao.search();
		return new ModelAndView("ADMIN/editArea","area",(AreaVo)ls1.get(0)).addObject("cityList",ls);
	}
	@RequestMapping(value="/updateArea.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute AreaVo vo)
	{
		this.dao1.update(vo);
		return new ModelAndView("redirect:viewArea.htm");
	}
}
