package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	ProductService ps;
	
	@Autowired
	public ProductController(ProductService ps) {
		this.ps = ps;
	}
	
	@GetMapping(path="/create")
	public ModelAndView createProduct(){		
		ModelAndView result=new ModelAndView("products/createOrUpdateProductForm");	
		result.addObject("product", new Product());
		result.addObject("productTypes", ps.getAllProductTypes());
		return result;
	}
	
	@PostMapping(path="/create")
	public ModelAndView saveProduct(@Valid Product product, BindingResult br){
		ModelAndView result;
		if(br.hasErrors()) {
			result=new ModelAndView("products/createOrUpdateProductForm", br.getModel());
		} else {
			ps.save(product);
			result=new ModelAndView("welcome");
			result.addObject("message", "The product was added succesfully");
		}
		return result;
	}
    
}