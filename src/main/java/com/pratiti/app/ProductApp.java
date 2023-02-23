package com.pratiti.app;

import java.util.List;

import com.pratiti.dao.ProductDao;
import com.pratiti.entity.Product;

public class ProductApp {
	
	public static void main(String[] args) {
//		Insert the data to the table
//		Product prod=new Product();
//		prod.setName("Realme 8");
//		prod.setPrice(13000);
//		prod.setQuantity(34);
		
		ProductDao productDao =new ProductDao();
//		productDao.add(prod);
		
		
		//Select the data from the table 
//		Product p=productDao.fetch(4);
//		System.out.println("Name :"+p.getName()+" | Price "+p.getPrice());		
		
		//fetching all the data
		//fetching data by specific name
//		List<Product> list=productDao.fetchByName("Iphone");
//		for(Product it:list)
//		{
//			System.out.println("Name :"+it.getName()+" | Price : "+it.getPrice()+" | Quantity: "+it.getQuantity());
//		}
//		
//		//update the attributes of the product
//		Product product=productDao.fetch(1);
//		product.setPrice(product.getPrice()-product.getPrice()*0.10);
//		productDao.update(product);
		
		productDao.deleteById(2);
		
	}
}
