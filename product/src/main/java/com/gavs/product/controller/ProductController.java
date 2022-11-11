package com.gavs.product.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gavs.product.model.Product;
import com.gavs.product.model.ProductRepository;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController{
	@Autowired
	private ProductRepository repo;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Product> getProducts()
	{
		List<Product> productList= new ArrayList<Product>();
		for(int i=1;i<3;i++)
		{
			Product p1= new Product();
			p1.setName("Phone"+i);
			p1.setPid(1+i);
			p1.setStock(100);
			p1.setPrice(234);
			
			productList.add(p1);
		}
		return productList;
	}
    @RequestMapping(value="/findProduct",method= RequestMethod.GET)
    public Product find(int pid){
    	Optional<Product>found = repo.findById(pid);
    	Product doc=found.get();
    	System.out.println(doc.getPid()+""+doc.getName()+""+doc.getPrice()+""+doc.getStock());
    	return doc;
    }
    @RequestMapping(value="/addProduct",method= RequestMethod.POST)
    public Product addProduct(@RequestBody Product p) 
    {
       return repo.save(p); 	
    }
    @RequestMapping(value="/deleteProduct",method= RequestMethod.DELETE)
    public void removeProduct(@RequestBody Product p) {
    	
          repo.deleteById(p.getPid());

        System.out.println("Deleted");
       
    }
    @RequestMapping(value="/updateProduct",method= RequestMethod.PUT)
    public Product modifyDoctorDetails(@RequestBody Product p) {
    	return repo.save(p);
    }
}
