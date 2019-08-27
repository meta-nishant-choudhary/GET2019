package dbms.com.metacube;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreFront {
	
	/**
	 * create connection of java with mysql server
	 * @return con object type: Connection
	 * @throws Exception
	 */
	public Connection buildConnection() {
		try {
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/StoreFront", "root", "Pra@ajm123");
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * this function is used to fetch the users order
	 * @param userId
	 * @throws Exception
	 */
	public void fetchOrdersOfUser(int userId) {
		try {
		Connection con = buildConnection();
		String query = "select id,date_of_order_placed AS DATE,amount from orders where status='Shipped' and user_id=? order by date_of_order_placed desc";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery(query);
		List<Order> orders = new ArrayList<Order>();
		while (rs.next()) {
			Order order = new Order();
			order.setId(rs.getInt(1));
			order.setDate_of_order(rs.getDate(2).toString());
			order.setAmount(rs.getInt(3));
			orders.add(order);
		}

		for (Order order : orders) {
			System.out.println(order.getId() + " " + order.getDate_of_order()
					+ " " + order.getAmount());
		}
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * used to add images in StoreFront DB
	 * @param productId
	 * @param images
	 * @throws Exception
	 */
	public void addImages(int productId, List<String> images) throws Exception {
		String query = "insert into image(product_id,image) values(?,?)";
		try {
			Connection conn = buildConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			conn.setAutoCommit(false);
			System.out.println("The SQL query is: " + query);
			System.out.println();

			for (int count = 0; count < images.size(); count++) {
				stmt.setInt(1, productId);
				stmt.setString(2, images.get(count));
				stmt.addBatch();
			}

			int[] result = stmt.executeBatch();
			System.out.println("The number of rows inserted: " + result.length);
			conn.commit();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public int setInactive() {
		String query = "update product set status='Inactive' WHERE id NOT IN(SELECT i.product_id FROM item_list i join orders o where"
				+ " o.id=i.order_Id AND DATEDIFF(CURDATE(),o.Date_of_order_placed)<365)";
		int numOfInactives = 0;
		try {
			Connection conn = buildConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println("The SQL query is: " + query);

			numOfInactives = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return numOfInactives;
	}

	/**
	 * This method: Select and display the category title of all top parent
	 * categories sorted alphabetically and the count of their child categories.
	 * 
	 * @throws Exception
	 */
	public void showCategories() {
		String query = "select DISTINCT c.parent_category, COUNT(c.parent_id) AS Numbber_Of_Children FROM category c GROUP BY c.parent_id ORDER BY c.parent_category";
		try {
			Connection conn = buildConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println("The SQL query is: " + query);
			ResultSet rset = stmt.executeQuery();
			List<Category> parentList = new ArrayList<>();
			while (rset.next()) {
				parentList.add(new Category(rset.getString("parent_category"),
						rset.getInt("Numbber_Of_Children")));
			}

			for (Category category : parentList) {
				System.out.println(category.getName() + "\t"
						+ category.getNumberOfChildren());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
