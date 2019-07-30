package com.metacube.graphicslibrary;


import java.util.Date;


public interface Shape {

	public static enum shapeType{Circle,Square,Rectangle,Triangle} 
	
	
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point aPoint);
	public Date getTimeStamp();
	public Shape.shapeType getShapeType();
	public int getId();
	public double getDistance();
}