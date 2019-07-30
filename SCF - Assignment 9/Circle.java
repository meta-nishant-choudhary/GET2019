package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

public class Circle implements Shape{
	public Shape.shapeType shapeType;
	public Point originPoint;
	private Point centerOfCircle;
	public double radius;
	private int RADIUS = 0;
	private double PI = 3.14;
	private Date timestamp;
	private final int id;
	
	
	public Circle(Point originPoint,List<Integer> parameters,int id) {
		this.shapeType=Shape.shapeType.Circle;
		this.originPoint=originPoint;
		this.radius=(double)parameters.get(RADIUS);
		this.timestamp=new Date();
		this.id=id;
		this.centerOfCircle = this.getCenter();
	}
	/*
	 * calculates the area of circle
	 */
	private double calculateArea() {
					
		double area = PI * (radius * radius);
		return area;
	}
	/**
	 * provides the area of Circle
	 * @return calculated area
	 */
	public double getArea() {
		return calculateArea();
	}
	/*
	 * calculate the circumference of Circle
	 */
	private double calculatePerimeter() {
			
		double area = 2.0 * PI * radius;
		return area;
	}
	/**
	 * provides the  of circumference
	 * @return calculated circumference
	 */
	public double getPerimeter() {
		return calculatePerimeter();
	}
	/**
	 * provides the origin of the Circle i.e. centre of Circle
	 */
	public Point getOrigin() {
		return new Point(this.originPoint.getX(),this.originPoint.getY());
	}
	/*
	 * point enclose check
	 * by finding the distance of point from the center of circle
	 */
	private boolean enclose(Point p) {
		
		double distance = Math.pow((p.getX()-this.centerOfCircle.getX()), 2) + Math.pow((p.getY()-this.centerOfCircle.getY()), 2);
		distance = Math.sqrt(distance);
		if((distance<radius)) {
			return true;
		}
		return false;
	}
	/**
	 * checks whether a given point is enclosed in Circle or not.
	 * @return true if the point is enclosed else false.
	 */
	public  boolean isPointEnclosed(Point p) {
		return enclose(p);
	}
	 
	public Date getTimeStamp() {
		Date getTimeStamp = new Date(timestamp.getTime());
		return getTimeStamp;
	}
	
	
	public Shape.shapeType getShapeType() {
		return this.shapeType;
	}
	public int getId() {
		return this.id;
	}
	/*
	 * provides the center of circle using the radius and origin point 
	 * takes the help of triangle equalities
	 */
	private Point getCenter(){
		double originX = this.originPoint.getX();
		double originY = this.originPoint.getY();
		double distance = Math.sqrt((originX*originX)+(originY*originY));
		double base = (originX*(distance+radius))/distance;
		double height = (originY*(distance+radius))/distance;
		return new Point(base,height);
		
	}
	/**
	 * provides the center of circle using the radius and origin point 
	 * @param origin 	origin of circle i.e. the origin will considered to be a point on the circle that lies on 
	 * 					the line connecting the center of the circle to the origin of the screen.
	 * @param radius	
	 * @return center of the circle
	 */
	public static Point getCenter(Point origin,double radius){
		double originX = origin.getX();
		double originY = origin.getY();
		double distance = Math.sqrt((originX*originX)+(originY*originY));
		double base = (originX*(distance+radius))/distance;
		double height = (originY*(distance+radius))/distance;
		return new Point(base,height);
		
	}
	public double getRadius() {
		return this.radius;
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