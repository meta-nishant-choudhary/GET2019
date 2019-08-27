package dbms.com.metacube;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) throws Exception {
		StoreFront sfObj = new StoreFront();
		List<String> images = new ArrayList<String>();
		images.add("Shirt1.jpg");
		images.add("Shirt2.jpg");
		images.add("Shirt3.jpg");
		images.add("Shirt4.jpg");

		sfObj.addImages(1, images);

		int numOfInactives = sfObj.setInactive();
		System.out.println("Number of inactives: " + numOfInactives);

		sfObj.showCategories();
	}
}
