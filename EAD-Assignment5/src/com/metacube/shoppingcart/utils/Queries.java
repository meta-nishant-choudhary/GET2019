package com.metacube.shoppingcart.utils;

public class Queries {
	
	public final static String GETALLPRODUCTS = "SELECT * FROM PRODUCT;";
	
	public final static String ADDUSER = "INSERT INTO USER(USERNAME) VALUES(?);";
	
	public final static String GETSHOPPINGCART = "select c.cartid,p.productname,c.price,c.quantity,c.total from cart c left join product p on p.productcode=c.productid  where c.userid=?;";
	
	public final static String LOGIN = "SELECT * FROM USER WHERE USERNAME=?;";
	
	public final static String INSTOCK = "SELECT QUANTITY FROM PRODUCT WHERE PRODUCTCODE=?";
	
	public final static String GETPRODUCTBYCODE = "SELECT * FROM PRODUCT WHERE PRODUCTCODE=?";
	
	public final static String ADDSHOPPINGCART = "INSERT INTO CART(USERID,PRODUCTID,QUANTITY,PRICE,TOTAL) VALUES(?,?,?,?,?)";
	
	public final static String REMOVEFROMCART = "DELETE FROM CART WHERE CARTID=?";
	
	public final static String GETCARTBYID="SELECT * FROM CART WHERE CARTID=?;";
	
	public final static String UPDATECART = "UPDATE CART SET QUANTITY=? AND TOTAL=? WHERE CARTID=?";
}
