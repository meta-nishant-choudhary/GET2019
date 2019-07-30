package com.metacube.graphicslibrary;

import java.util.Date;
import java.util.List;

public class Triangle implements Shape {
 private Shape.shapeType shaTyp;
 private final int BASE = 0;
 private final int PERPENDICULAR =1;
 private Point originPoint;
 private Date timestamp;
 private double perp;
 private double base;
 private final int id;
 
 public Triangle(Point originPoint,List<Integer> parameter,int id) {
	 this.shaTyp=Shape.shapeType.Triangle;
	 this.originPoint=originPoint;
	 this.timestamp=new Date();
	 this.base = parameter.get(BASE);
	 this.perp= parameter.get(PERPENDICULAR);
	 this.id=id;
 }

 	public Shape.shapeType getShapeType() {
		return this.shaTyp;
	}

	public Point getOrigin() {
		return new Point(this.originPoint.getX(),this.originPoint.getY());
	}

	public Date getTimeStamp() {
		Date getTimeStamp = new Date(this.timestamp.getTime());
		return getTimeStamp;
	}
	public int getId() {
		return this.id;
	}
	public double getPerp() {
		return perp;
	}

	public double getBase() {
		return base;
	}
	/*
	 * calculates the area of triangle
	 */
	private double calculatedArea() {
		double area = ((double)this.base*(double)this.perp)/2;
		return area;
	}
	/**
	 * provides the area of Triangle
	 * @return calculated area
	 */
	public double getArea() {
		return calculatedArea();
	}
	/*
	 * calculates the perimeter of triangle
	 */
	private double calculatedPerimeter() {
	double hyp = Math.sqrt((this.base*this.base)+(this.perp*this.perp));
			return ((double)this.base+(double)this.perp+hyp);
	}
	/**
	 * provides the perimeter of triangle
	 * @return calculated perimeter
	 */
	public double getPerimeter() {
		return calculatedPerimeter();
	}

	

	/*
	 * helper method to calculate the area of triangle using determinants 
	 */
	private double triangleArea(Point a,Point b,Point c){
		//Math.abs returns the positive value
		return  Math.abs(((a.getX())*(b.getY()-c.getY()) + b.getX()*(c.getY()-a.getY())+  c.getX()*(a.getY()-b.getY()))/2.0); 
	}
	
	/*
	 * checks whether a point is inside or outside the triangle
	 * by finding the area of three triangle made by the point
	 * if the sum of all the triangle is equal to the sum of main triangle then point is enclosed
	 * else false
	 */
	private boolean enclose(Point p) {
		double A = this.getArea();
		Point b = new Point(this.originPoint.getX()+this.base,this.originPoint.getY());
		Point c = new Point(this.originPoint.getX(),this.originPoint.getY()+this.perp);
		
		double a1 = triangleArea(p,b,c);
		double a2 = triangleArea(this.originPoint,p,c);
		double a3 = triangleArea(this.originPoint,b,p);
		
		return (A== a1+a2+a3);
	}
	/**
	 * check a point is inside a triangle or outside
	 * @return true if point is inside else false
	 */
	public boolean isPointEnclosed(Point p) {
		return enclose(p);
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