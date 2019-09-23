package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.entities.Product;

public class ProductFacade {
	
	static ProductFacade productFacade=null;
	ProductDao productDao;
	
	public ProductFacade(){
		this.productDao = new ProductDao();
	}
	
	public static ProductFacade getInstance(){
		if(productFacade == null){
			productFacade = new ProductFacade();
		}
		return productFacade;
	}
	
	public List<Product> getallProducts() throws Exception{
		return this.productDao.getAllProduct();
	}

	public boolean productInStore(Integer productId,Integer quantity) throws Exception{
		return this.productDao.productInStore(productId, quantity);
	}
	
	public Product getProductbyCode(Integer productcode) throws Exception{
		return this.productDao.getProductbyCode(productcode);
	}
}
