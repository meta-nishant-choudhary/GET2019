package com.metacube.graphicslibrary;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ShapeFactoryTest {

	@Test
	public void screenCreation(){
		Screen newScreen = new Screen(1920.00,1080.00);
		assertEquals(1920.00,newScreen.getXMAX(),0.002);
		assertEquals(1080.00,newScreen.getYMAX(),0.002);
	}
	// invalid screen dimension 
	@Test(expected = AssertionError.class)
	public void screenCreationNegative(){
		Screen newScreen = new Screen(-1920.00,1080.00);
		assertEquals(1920.00,newScreen.getXMAX(),0.002);
		assertEquals(1080.00,newScreen.getYMAX(),0.002);
	}
	//checking all the properties of square
	@Test
	public void addSquareToScreen(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Square, new Point(3.0,4.0),parameters));
		List<Shape> resultList = newScreen.getList();
		assertEquals(Shape.shapeType.Square,resultList.get(0).getShapeType());
		assertEquals(true,resultList.get(0).getOrigin().equals(new Point (3.0,4.0)));
		assertEquals(5,((Square)(resultList.get(0))).getWidth());
		assertEquals(25.0,resultList.get(0).getArea(),0.002);
		assertEquals(20.0,resultList.get(0).getPerimeter(),0.002);
		assertEquals(true,resultList.get(0).isPointEnclosed(new Point(5.0,7.0)));
		assertEquals(false,resultList.get(0).isPointEnclosed(new Point(1.0,7.0)));
	}
	// square origin out of screen
	@Test(expected = AssertionError.class)
	public void addSquareToScreenNegative(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Square, new Point(-3.0,4.0),parameters));
	}
	// square width 100000
	@Test(expected = AssertionError.class)
	public void bigSquare(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(100000);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Square, new Point(3.0,4.0),parameters));
	}
	
	// checking all the properties of circle 
	@Test
	public void addCircleToScreen(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Circle, new Point(3.0,4.0),parameters));
		Shape resultList = newScreen.getList().get(0);
		assertEquals(Shape.shapeType.Circle,resultList.getShapeType());
		assertEquals(true,resultList.getOrigin().equals(new Point (3.0,4.0)));
		assertEquals(5,((Circle)(resultList)).getRadius(),00.0002);
		assertEquals(78.5,resultList.getArea(),0.002);
		assertEquals(31.4,resultList.getPerimeter(),0.002);
		assertEquals(true,resultList.isPointEnclosed(new Point(4.0,4.0)));
		assertEquals(false,resultList.isPointEnclosed(new Point(1.0,7.0)));
	}
	
	
	//circle radius = 2000 i.e. more than screen size
	@Test(expected=AssertionError.class)
	public void addCircleToScreenNegative(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(2000);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Circle, new Point(3.0,5.0),parameters));
		
	}
	//circle origin point such that some part of circle is out side the screen
	@Test(expected=AssertionError.class)
	public void circleOutScreen(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Circle, new Point(3.0,1.0),parameters));
		}
	// checking all properties of rectangle
	@Test
	public void addRectangleToScreen() {
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		parameters.add(7);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Rectangle, new Point(3.0,4.0),parameters));
		Shape resultList = newScreen.getList().get(0);
		assertEquals(Shape.shapeType.Rectangle,resultList.getShapeType());
		assertEquals(true,resultList.getOrigin().equals(new Point (3.0,4.0)));
		assertEquals(5,((Rectangle)(resultList)).getWidth(),00.0002);
		assertEquals(7,((Rectangle)(resultList)).getHeight(),00.0002);
		assertEquals(35,resultList.getArea(),0.002);
		assertEquals(24,resultList.getPerimeter(),0.002);
		assertEquals(true,resultList.isPointEnclosed(new Point(5.0,7.0)));
		assertEquals(false,resultList.isPointEnclosed(new Point(1.0,7.0)));
	}
	// rectangle with height 70000
	@Test(expected=AssertionError.class)
	public void rectOutScreen() {
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		parameters.add(70000);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Rectangle, new Point(3.0,4.0),parameters));
	}
	
	@Test
	public void addTriToScreen() {
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		parameters.add(7);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Triangle, new Point(3.0,4.0),parameters));
		Shape resultList = newScreen.getList().get(0);
		
		assertEquals(Shape.shapeType.Triangle,resultList.getShapeType());
		assertEquals(true,resultList.getOrigin().equals(new Point (3.0,4.0)));
		assertEquals(5,((Triangle)(resultList)).getBase(),00.0002);
		assertEquals(7,((Triangle)(resultList)).getPerp(),00.0002);
		assertEquals(17.5,resultList.getArea(),0.002);
		assertEquals(20.6,resultList.getPerimeter(),0.02);
		assertEquals(true,resultList.isPointEnclosed(new Point(4.0,5.0)));
		assertEquals(false,resultList.isPointEnclosed(new Point(1.0,7.0)));
	}
	
	@Test
	public void testForSorting(){
		Screen newScreen = new Screen(1920.00,1080.00);
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(5);
		parameters.add(7);
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Triangle, new Point(100.0,4.0),parameters));
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Rectangle, new Point(3.0,200.0),parameters));
		assertEquals(true,newScreen.addShapeToScreen(Shape.shapeType.Circle, new Point(104.0,356.0),parameters));
		
		List<Shape> resultList = new ArrayList<Shape>(newScreen.sort("Area"));
		List<Shape> resultList1 = new ArrayList<Shape>(newScreen.sort("Date"));
		List<Shape> resultList2 = new ArrayList<Shape>(newScreen.sort("Perimeter"));
		List<Shape> resultList3 = new ArrayList<Shape>(newScreen.sort("Distance"));
		
	}
	
	
	
	
}