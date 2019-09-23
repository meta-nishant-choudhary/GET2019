package com.metacube.shoppingcart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.entities.Product;
import com.metacube.shoppingcart.utils.DatabaseConnection;
import com.metacube.shoppingcart.utils.Queries;

public class ProductDao {
	
	public List<Product> getAllProduct() throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		Statement stmt = dbcon.con.createStatement();
		ResultSet rs = stmt.executeQuery(Queries.GETALLPRODUCTS);
		List<Product> list = new ArrayList<Product>();
		while(rs.next()){
			Product product = new Product();
			product.setProductcode(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setProductType(rs.getString(3));
			product.setQuantity(rs.getInt(4));
			product.setProductPrice(rs.getDouble(5));
			list.add(product);			
		}
		return list;
	}
	
	public boolean productInStore(Integer productId,Integer quantity) throws Exception{
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.INSTOCK);
		pstmt.setInt(1, productId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			if(quantity<rs.getInt(1)){
				return true;
			}
		}
		return false;
	}
	
	public Product getProductbyCode(Integer productcode) throws Exception{
		Product product = new Product();
		DatabaseConnection dbcon = DatabaseConnection.getInstances();
		PreparedStatement pstmt = dbcon.con.prepareStatement(Queries.GETPRODUCTBYCODE);
		pstmt.setInt(1, productcode);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			product.setProductcode(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setProductType(rs.getString(3));
			product.setQuantity(rs.getInt(4));
			product.setProductPrice(rs.getDouble(5));
		}
		return product;
	}
	
}
