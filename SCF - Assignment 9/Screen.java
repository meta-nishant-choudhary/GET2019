package com.metacube.graphicslibrary;

import java.util.List;



import java.util.ArrayList;

public class Screen {

	private double XMIN= 0.00;
	private double XMAX;
	private double YMIN=0.00;
	private double YMAX;
	private List<Shape> listOfShapes = new ArrayList<Shape>();
	
	public Screen(double xLimit,double yLimit){
		if(validateScreen(xLimit,yLimit)){
			this.XMAX=xLimit;
			this.YMAX=yLimit;
		}
		else{
			throw new AssertionError("Screen dimension are illegal");
		}
	}
	
	private boolean validateScreen(double xLimit,double yLimit){
		if(xLimit<=0 || yLimit<=0){
			return false;
		}
		return true;
	}
	
	private boolean checkPoint(Shape.shapeType shaTyp,Point p,List<Integer> parameters) {
		if(p.getX()>=XMIN && p.getX()<=XMAX && p.getY()>=YMIN && p.getY()<=YMAX) {
			if(shaTyp==Shape.shapeType.Circle) {
				return ScreenUtil.validateCircle(p, parameters.get(0), this);
			}
			else if(shaTyp==Shape.shapeType.Rectangle) {
				return ScreenUtil.validateRectangle(p, parameters.get(0),parameters.get(1),this);
			}
			else if(shaTyp==Shape.shapeType.Square) {
				return ScreenUtil.validateSquare(p, parameters.get(0),this);
			}
			else if(shaTyp==Shape.shapeType.Triangle) {
				return ScreenUtil.validateTriangle(p, parameters.get(0),parameters.get(1),this);
			}
			
		}
		return false;
	}
	
	public boolean addShapeToScreen(Shape.shapeType shaTyp,Point origin,List<Integer> parameters) {
		if(this.checkPoint(shaTyp,origin,parameters)) {
			listOfShapes.add(ShapeFactory.createShape(shaTyp, origin, parameters));
			
			return true;
		}
		throw new AssertionError("shape can't be added to screen");
		
	}
	
	public boolean removeShape(int id) {
		int sub=0;
		for(int i=0;i<this.listOfShapes.size()-sub;i++) {
			if(listOfShapes.get(i).getId()==id) {
				listOfShapes.remove(i);
				sub++;
				
				return true;
			}
		}
		return false;
	}
	
	public boolean removeAllShape(Shape.shapeType shaTyp) {
		List<Shape> tobeRemoved = new ArrayList<Shape>();
		
		for(int i=0;i<this.listOfShapes.size();i++) {
			if(listOfShapes.get(i).getShapeType()==shaTyp) {
				tobeRemoved.add(listOfShapes.get(i));
			}
		}
		this.listOfShapes.removeAll(tobeRemoved);
		return true;
	}
	
	public List<Shape> enclosedShapes(Point p) {
		List<Shape> enclosingShapes = new ArrayList<Shape>();
		for(int i=0;i<this.listOfShapes.size();i++) {
			if(this.listOfShapes.get(i).isPointEnclosed(p)) {
				enclosingShapes.add(this.listOfShapes.get(i));
			}
		}
		return enclosingShapes;
	}
	
	public List<Shape> getList(){
		List<Shape> result = new ArrayList<Shape>();
		result = this.listOfShapes;
		return result;
	}
	
	public double getXMAX(){
		return this.XMAX;
	}
	public double getYMAX(){
		return this.YMAX;
	}
	
	public List<Shape> sort(String basedOn){
		List<Shape> sortedList = new ArrayList<Shape>();
		
		if("Area".equalsIgnoreCase(basedOn)){
			sortedList=ScreenUtil.radixsortArea(listOfShapes);
		}
		else if("Perimeter".equalsIgnoreCase(basedOn)){
			sortedList=ScreenUtil.radixsortPerimeter(listOfShapes);
		}
		else if("Distance".equalsIgnoreCase(basedOn)){
			sortedList=ScreenUtil.radixsortDistance(listOfShapes);
		}
		else if("Date".equalsIgnoreCase(basedOn)){
			sortedList=ScreenUtil.sortDate(listOfShapes);
		}
		
		
		
		return sortedList;
	}
	
	
	
}
