package com.metacube.shoppingcart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.entities.Product;
import com.metacube.shoppingcart.entities.ShoppingCart;
import com.metacube.shoppingcart.entities.ViewCart;
import com.metacube.shoppingcart.utils.DatabaseConnection;
import com.metacube.shoppingcart.utils.Queries;

public class ShoppingCartDao {
	
	public List<ViewCart> getShoppingCart(Integer userId) throws Exception{
		
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.GETSHOPPINGCART);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		List<ViewCart> cartList = new ArrayList<ViewCart>();
		while(rs.next()){
			ViewCart cart =new ViewCart();
			cart.setCartId(rs.getInt(1));
			cart.setProductName(rs.getString(2));
			cart.setPrice(rs.getDouble(3));
			cart.setQuantity(rs.getInt(4));
			cart.setTotal(rs.getDouble(5));
			cartList.add(cart);
		}
		return cartList;		
	}
	
	public boolean addItemToCart(ShoppingCart cart) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.ADDSHOPPINGCART);
		pstmt.setInt(1, cart.getUserid());
		pstmt.setInt(2, cart.getProductid());
		pstmt.setInt(3, cart.getQuantity());
		pstmt.setDouble(4, cart.getPrice());
		pstmt.setDouble(5, cart.getTotal());
		
		if(pstmt.executeUpdate()>0)
			return true;
		return false;
	}	
	
	public boolean removeItemFromcart(Integer cartId) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.REMOVEFROMCART);
		pstmt.setInt(1, cartId);
		if(pstmt.executeUpdate()>0){
			return true;
		}
		return false;
	}
	
	public boolean updateCart(Integer cartId,Integer quantity) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.GETCARTBYID);
		pstmt.setInt(1, cartId);
		ResultSet rs = pstmt.executeQuery();
		Double price=null;
		if(rs.next()){
			price = rs.getDouble(5);
		}
		Double total = quantity*price;
		PreparedStatement pstmt2 = dbcon.con.prepareStatement(Queries.UPDATECART);
		pstmt2.setInt(1, quantity);
		pstmt2.setDouble(2, total);
		pstmt2.setInt(3, cartId);
		if(pstmt2.executeUpdate()>0){
			return true;
		}
		return false;
	}

}
