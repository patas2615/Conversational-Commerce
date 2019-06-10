package abc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import abc.Vo.AreaVo;

@Controller
public class userController {

	@RequestMapping(value="/CartTraditional.htm",method=RequestMethod.GET)
	public ModelAndView CartTraditional()
	{
		return new ModelAndView("USER/CartTraditional");
	}
	@RequestMapping(value="/checkout.htm",method=RequestMethod.GET)
	public ModelAndView Checkout()
	{
		return new ModelAndView("USER/Checkout");
	}
	@RequestMapping(value="/contact.htm",method=RequestMethod.GET)
	public ModelAndView Contact()
	{
		return new ModelAndView("USER/Contact");
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public ModelAndView Login()
	{
		return new ModelAndView("USER/Login");
	}
	@RequestMapping(value="/product.htm",method=RequestMethod.GET)
	public ModelAndView Product()
	{
		return new ModelAndView("USER/Product");
	}
	@RequestMapping(value="/shop.htm",method=RequestMethod.GET)
	public ModelAndView Shop()
	{
		return new ModelAndView("USER/Shop");
	}
	@RequestMapping(value="/wishlist.htm",method=RequestMethod.GET)
	public ModelAndView Wishlist()
	{
		return new ModelAndView("USER/Wishlist");
	}
	

	
}
