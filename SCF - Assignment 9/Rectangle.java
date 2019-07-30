package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

public class Rectangle implements Shape {
	private final int WIDTH = 0;
	private final int HEIGHT = 1;
	private Shape.shapeType shapeType;
	private Point originPoint;
	private Date timestamp;
	private int width;
	private int height;
	private final int id;
	
	public Rectangle(Point originPoint,List<Integer> parameters,int id) {
		this.shapeType=Shape.shapeType.Rectangle;
		this.originPoint=originPoint;
		this.width=parameters.get(WIDTH);
		this.height=parameters.get(HEIGHT);
		this.timestamp = new Date();
		this.id=id;
	}
	/*
	 * calculates the area of rectangle
	 */
	private double calculateArea() {
		double area = (double)width * (double)height;
		return area;
	}
	/**
	 * provides the area of Rectangle
	 * @return calculated area
	 */
	public double getArea() {
		return calculateArea();
	}
	/*
	 * calculate the perimeter of rectangle
	 */
	private double calculatePerimeter() {
		
		double area = 2.0 *(height+width);
		return area;
	}
	/**
	 * provides the parameter of rectangle
	 * @return calculated parameter
	 */
	public double getPerimeter() {
		return calculatePerimeter();
	}
	/**
	 * provides the origin of the rectangle i.e. left bottom point.
	 */
	public Point getOrigin() {
		return new Point(this.originPoint.getX(),this.originPoint.getY());
	}
	/*
	 * point enclose check
	 */
	private boolean enclose(Point p) {
		
		if(p.getX()>=this.originPoint.getX() && p.getY()>=this.originPoint.getY() &&
				p.getX()<=this.originPoint.getX()+(double)width && p.getY()<=this.originPoint.getY()+(double)height) {
			return true;
		}
		return false;
	}
	
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	/**
	 * checks whether a given point is enclosed in Rectangle or not.
	 * @return true if the point is enclosed else false.
	 */
	public  boolean isPointEnclosed(Point p) {
		return enclose(p);
	}
	public Date getTimeStamp() {
		Date getTimeStamp = new Date(this.timestamp.getTime());
		return getTimeStamp;
	}
	public Shape.shapeType getShapeType() {
		return this.shapeType;
	}
	public int getId() {
		return this.id;
	}
	/**
	 * provides the distance of origin from screen origin
	 * @return  distance
	 */
	public double getDistance(){
		double d = ((this.originPoint.getX()*this.originPoint.getX())+(this.originPoint.getY()*this.originPoint.getY()));
		d = Math.sqrt(d);
		return d;
	}
	
	
}
