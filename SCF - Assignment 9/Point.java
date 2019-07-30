package com.metacube.graphicslibrary;

public class Point {
	private double x;
	private double y;
	
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	/**
	 * checks two points are equal or not
	 * @param p point to be checked
	 * @return true if the points are equal
	 */
	public boolean equals(Point p) {
		if(this.x==p.x && this.y == p.y) {
			return true;
		}
		return false;
	}
	
}