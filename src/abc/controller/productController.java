package abc.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import abc.Dao.BrandDao;
import abc.Dao.CategoryDao;
import abc.Dao.ProductDao;
import abc.Dao.ShopDao;
import abc.Dao.SubCategoryDao;
import abc.Vo.ProductVo;

@Controller
public class productController {
	
	@Autowired CategoryDao dao;
	@Autowired SubCategoryDao dao1;
	@Autowired BrandDao dao2;
	@Autowired ShopDao dao3;
	@Autowired ProductDao dao4;
	
	@RequestMapping(value="/addProduct.htm",method=RequestMethod.GET)
	public ModelAndView Add()
	{
		List ls = this.dao.search();
		List ls1 = this.dao1.search();
		List ls2 = this.dao2.search();
		List ls3 = this.dao3.search();
		return new ModelAndView("ADMIN/addProduct","product",new ProductVo()).addObject("catList",ls).addObject("sublist",ls1).addObject("brandlist",ls2).addObject("shoplist",ls3);
	}
	
	@RequestMapping(value="/viewProduct.htm",method=RequestMethod.GET)
	public ModelAndView View()
	{
		List ls4= this.dao4.search();
		return new ModelAndView("ADMIN/viewProduct","productlist",ls4);
	}
	@RequestMapping(value="/insertProduct.htm",method=RequestMethod.POST)
	public ModelAndView insert(HttpSession session,@RequestParam("file") CommonsMultipartFile file,@ModelAttribute ProductVo vo)
	{
		String path=session.getServletContext().getRealPath("/");
		
		String pathFInal=path+"\\doc";
		System.out.println("path---------------------"+pathFInal);
		
		
        String filename=file.getOriginalFilename();  
        System.out.println(filename);
        System.out.println("file name........!!!!"+filename);
        
        System.out.println(path+" "+filename);  
        try{  
        byte barr[]=file.getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(pathFInal+"\\"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
          
        }catch(Exception e){
        	System.out.println(e);
        }        
		
		vo.setProductImageName(filename);
		vo.setProductImagePath(pathFInal);
		
		this.dao4.insert(vo);
		return new ModelAndView("redirect:addProduct.htm");
	}
	@RequestMapping(value="/deleteProduct.htm",method=RequestMethod.GET)
	public ModelAndView delete(ProductVo vo,@RequestParam("id")int id)
	{
		vo.setProductId(id);
		this.dao4.delete1(vo);
		return new ModelAndView("redirect:viewProduct.htm");
	}
	@RequestMapping(value="/editProduct.htm",method=RequestMethod.GET)
	public ModelAndView Edit(@RequestParam("id")int id,ProductVo vo)
	{
		vo.setProductId(id);
		List editls = this.dao4.edit(vo);
		List ls = this.dao.search();
		List ls1 = this.dao1.search();
		List ls2 = this.dao2.search();
		List ls3 = this.dao3.search();
		return new ModelAndView("ADMIN/addProduct","product",(ProductVo)editls.get(0)).addObject("catList",ls).addObject("sublist",ls1).addObject("brandlist",ls2).addObject("shoplist",ls3);

	}
	@RequestMapping(value="/updateProduct.htm",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute ProductVo vo)
	{
		this.dao4.update(vo);
		return new ModelAndView("redirect:viewProduct.htm");
	}
}
