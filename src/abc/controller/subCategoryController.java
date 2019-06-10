package abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.CategoryDao;
import abc.Dao.SubCategoryDao;
import abc.Vo.CategoryVo;
import abc.Vo.SubCategoryVo;
@Controller

public class subCategoryController {
	
	@Autowired CategoryDao dao;
	@Autowired SubCategoryDao dao1;
	
		@RequestMapping(value="/addSubcategory.htm",method=RequestMethod.GET)
		public ModelAndView Add()
		{
			List ls = this.dao.search();
			
			return new ModelAndView("ADMIN/addSubcategory","subCategory",new SubCategoryVo()).addObject("catList",ls);
		}
		
		@RequestMapping(value="/viewSubcategory.htm",method=RequestMethod.GET)
		public ModelAndView View()
		{
			List ls1= this.dao1.search();
			return new ModelAndView("ADMIN/viewSubcategory","sublist",ls1);
		}
		@RequestMapping(value="/insertSubCategory.htm",method=RequestMethod.POST)
		public ModelAndView insert(@ModelAttribute SubCategoryVo vo)
		{
			this.dao1.insert(vo);
			return new ModelAndView("redirect:addSubcategory.htm");
		}
		
		@RequestMapping(value="/delete.htm",method=RequestMethod.GET)
		public ModelAndView delete(SubCategoryVo subcatvo,@RequestParam("id")int id)
		{
			subcatvo.setSubcategoryId(id);
			this.dao1.delete(subcatvo);
			return new ModelAndView("redirect:viewSubcategory.htm");
			
		}
		@RequestMapping(value="/editSubcategory.htm",method=RequestMethod.GET)
		public ModelAndView Edit(@RequestParam("id")int id,SubCategoryVo subcatvo)
		{
			subcatvo.setSubcategoryId(id);
			List ls1 = this.dao1.edit(subcatvo);
			List ls = this.dao.search();
			return new ModelAndView("ADMIN/editSubcategory","subCategory",(SubCategoryVo)ls1.get(0)).addObject("catList",ls);
		}
		@RequestMapping(value="/updatesubcategory.htm",method=RequestMethod.POST)
		public ModelAndView update(@ModelAttribute SubCategoryVo vo)
		{
			this.dao1.update(vo);
			return new ModelAndView("redirect:viewSubcategory.htm");
		}
		

		
		
}
