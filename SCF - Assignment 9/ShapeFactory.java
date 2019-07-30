package com.metacube.graphicslibrary;

import java.util.List;


public class ShapeFactory {
	private static int id=0;
	private ShapeFactory(){};
	
	
	/**
	 * creates the required shape 
	 * @param shapeType
	 * @param originPoint  
	 * @param parameters
	 * @return the object of the created shape object
	 */
	public static Shape createShape(Shape.shapeType shapeType,Point originPoint,List<Integer> parameters) {
		
		Shape newShape=null;
		
		if(Shape.shapeType.Circle==shapeType) {
			newShape = new Circle(originPoint,parameters,++id);
		}else if(Shape.shapeType.Square==shapeType) {
			newShape = new Square(originPoint,parameters,++id);
		}else if(Shape.shapeType.Rectangle==shapeType) {
			newShape = new Rectangle(originPoint,parameters,++id);
		}else if(Shape.shapeType.Triangle==shapeType) {
			newShape = new Triangle(originPoint,parameters,++id);
		}
		
		
		
		return newShape;
	}
	
}