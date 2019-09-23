package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.ShoppingCartDao;
import com.metacube.shoppingcart.entities.ShoppingCart;
import com.metacube.shoppingcart.entities.ViewCart;

public class ShoppingCartFacade {

	static ShoppingCartFacade cartfacade = null;
	ShoppingCartDao cartDao;
	
	public ShoppingCartFacade(){
		this.cartDao = new ShoppingCartDao();
	}
	
	public static ShoppingCartFacade getInstance(){
		if(cartfacade == null){
			cartfacade = new ShoppingCartFacade();
		}
		return cartfacade;
	}
	
	public List<ViewCart> getShoppingCart(Integer userId) throws Exception{
		return this.cartDao.getShoppingCart(userId);
	}
	
	
	public boolean addItemToCart(ShoppingCart cart) throws Exception{
		return this.cartDao.addItemToCart(cart);
	}
	
	public boolean removeItemFromcart(Integer cartId) throws Exception{
		return this.cartDao.removeItemFromcart(cartId);
	}
	
	public boolean updateCart(Integer cartId,Integer quantity) throws Exception{
		return this.cartDao.updateCart(cartId, quantity);
	}
}
