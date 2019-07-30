package com.metacube.graphicslibrary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Square implements Shape {
	private Shape.shapeType shapeType;
	private Point originPoint;
	private List<Integer> parameters;
	private final int WIDTH =0;
	private Date timestamp;
	private final int id;
	
	public Square(Point originPoint,List<Integer> parameters,int id) {
		this.shapeType=Shape.shapeType.Square;
		this.originPoint=originPoint;
		this.parameters=new ArrayList<Integer>(parameters);
		this.timestamp = new Date();
		this.id=id;
	}
	/*
	 * calculates the area of square
	 */
	private double calculateArea() {
		int width = parameters.get(WIDTH).intValue();			//parameters will be having only width
		double area = (double)width * (double)width;
		return area;
	}
	/**
	 * provides the area of Square
	 * @return calculated area
	 */
	public double getArea() {
		return calculateArea();
	}
	/*
	 * calculate the parameter of square
	 */
	private double calculatePerimeter() {
		int width = parameters.get(WIDTH).intValue();			//parameters will be having only width
		double area = 4.0 * (double)width;
		return area;
	}
	/**
	 * provides the parameter of Square
	 * @return calculated parameter
	 */
	public double getPerimeter() {
		return calculatePerimeter();
	}
	/**
	 * provides the origin of the Square i.e. left bottom point.
	 */
	public Point getOrigin() {
		return new Point(this.originPoint.getX(),this.originPoint.getY());
	}
	/*
	 * point enclose check
	 */
	private boolean enclose(Point p) {
		int width = parameters.get(WIDTH).intValue();
		
		if(p.getX()>=this.originPoint.getX() && p.getY()>=this.originPoint.getY() &&
				p.getX()<=this.originPoint.getX()+(double)width && p.getY()<=this.originPoint.getY()+(double)width) {
			return true;
		}
		return false;
	}
	/**
	 * checks whether a given point is enclosed in Square or not.
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
	public int getWidth() {
		return this.parameters.get(WIDTH);
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