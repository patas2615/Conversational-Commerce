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
import abc.Dao.ShopDao;
import abc.Vo.AreaVo;
import abc.Vo.ShopVo;

@Controller

public class shopController {
	@Autowired CityDao dao;
	@Autowired AreaDao dao1;
	@Autowired ShopDao dao2;
	@RequestMapping(value="/addShop.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		List ls = this.dao.search();
		List ls1 = this.dao1.search();
		return new ModelAndView("ADMIN/addShop","shop",new ShopVo()).addObject("cityList",ls).addObject("arealist",ls1);
	}
	
	@RequestMapping(value="/viewShop.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls2= this.dao2.search();
		return new ModelAndView("ADMIN/viewShop","shoplist",ls2);
	}
	@RequestMapping(value="/insertShop.htm",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute ShopVo vo)
	{
		this.dao2.insert(vo);
		return new ModelAndView("redirect:addShop.htm");
	}
	@RequestMapping(value="/deleteShop.htm",method=RequestMethod.GET)
	public ModelAndView delete(ShopVo vo,@RequestParam("id")int id)
	{
		vo.setShopId(id);
		this.dao2.delete(vo);
		return new ModelAndView("redirect:viewShop.htm");
		
	}
	@RequestMapping(value="/editShop.htm",method=RequestMethod.GET)
	public ModelAndView Edit(@RequestParam("id")int id,ShopVo vo)
	{
		vo.setShopId(id);
		List ls2 = this.dao2.edit(vo);
		List ls = this.dao.search();
		List ls1 = this.dao1.search();
		return new ModelAndView("ADMIN/editShop","shop",(ShopVo)ls2.get(0)).addObject("cityList",ls).addObject("arealist",ls1);
	}
	@RequestMapping(value="/updateShop.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute ShopVo vo)
	{
		this.dao2.update(vo);
		return new ModelAndView("redirect:viewShop.htm");
	}
}
