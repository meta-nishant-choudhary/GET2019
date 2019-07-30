package com.metacube.graphicslibrary;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public final class ScreenUtil {
	private ScreenUtil() {};
	/**
	 * validate the required circle can be created or not
	 * @param p origin point of the circle
	 * @param radius
	 * @param ref Screen reference
	 * @return true if the circle can be created, else false
	 */
	public static boolean validateCircle(Point p,int radius,Screen ref) {
		Point center = Circle.getCenter(p, (double)radius);
		if(center.getX()-(double)radius>=0 && center.getX() +(double)radius <= ref.getXMAX() && 
		   center.getY()-(double)radius>=0 && center.getY() +(double)radius<= ref.getYMAX()){
			return true;
		}
		return false;
	}
	/**
	 * validate the required Square can be created or not
	 * @param p	origin point of the square 
	 * @param width
	 * @param ref Screen reference
	 * @return true if the square can be created, else false
	 */
	public static boolean validateSquare(Point p,int width,Screen ref) {
		if(p.getX()+(double)width<=ref.getXMAX() && p.getY()+(double)width<=ref.getYMAX()) {
			return true;
		}
		return false;
	}
	/**
	 * validate the required rectangle can be created or not
	 * @param p origin point of the rectangle
	 * @param width		
	 * @param height
	 * @param ref Screen reference
	 * @return true if the rectangle can be created, else false
	 */
	public static boolean validateRectangle(Point p,int width,int height,Screen ref) {
		if(p.getX()+(double)width<=ref.getXMAX() && p.getY()+(double)height<=ref.getYMAX()) {
			return true;
		}
		return false;
	}
	/**
	 * validate the required Triangle can be created or not
	 * @param p	origin point of the triangle 
	 * @param width 	base of triangle
	 * @param height 	perpendicular of triangle
	 * @param ref Screen reference
	 * @return true if the triangle can be created, else false
	 */
	public static boolean validateTriangle(Point p,int base,int perp,Screen ref) {
		if(p.getX()+(double)base<=ref.getXMAX() && p.getY()+(double)perp<=ref.getYMAX()) {
			return true;
		}
		return false;
	}
	/*
	 * for getting the max area or perimeter
	 */
	private static double getMax(List<Shape> list){
		double max= list.get(0).getArea();
		for(int i=1;i<list.size();i++){
			if(list.get(i).getArea()>max){
				max=list.get(i).getArea();
			}
		}
		return max;
	}
	/*
	 * count sort algorithm 
	 * getting a kind of hash with the help of count array 
	 * then sorting according to a radix
	 */
	private static void countSortArea(List<Shape> list,int exp){
		Shape[] tempResult1 = new Shape[list.size()];
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (int i = 0; i < list.size(); i++) {
	          double a = (list.get(i).getArea()/exp)%10;
	          int j = (int) Math.round(a);
			 count[ j ]++; 
		 }
		 for (int i = 1; i < 10; i++){
	            count[i] += count[i - 1]; 
		 }
		 for (int i = list.size()-1; i >= 0; i--) 
	        { 
			 double a = (list.get(i).getArea()/exp)%10;
	          int j = (int) Math.round(a);
	           int index = count[j]-1; 
	          tempResult1[index] = list.get(i);  
	            count[ j ]--; 
	        }
	            list.clear();
	            list.addAll(Arrays.asList(tempResult1));
	}
	/**
	 * performs the radix sort based on area 
	 * @param list
	 * @return sorted list;
	 */
	public static List<Shape> radixsortArea(List<Shape> list) 
    { 
        double max = getMax(list); 
        for (int exp = 1; max/exp >  0; exp *= 10) {
            countSortArea(list, exp); 
        }
        return list;
    } 
	
	/*
	 * count sort algorithm 
	 * getting a kind of hash with the help of count array 
	 * then sorting according to a radix
	 */
	private static void countSortPerimeter(List<Shape> list,int exp){
		Shape[] tempResult1 = new Shape[list.size()];
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (int i = 0; i < list.size(); i++) {
	          double a = (list.get(i).getPerimeter()/exp)%10;
	          int j = (int) Math.round(a);
			 count[ j ]++; 
		 }
		 for (int i = 1; i < 10; i++){
	            count[i] += count[i - 1]; 
		 }
		 for (int i = list.size()-1; i >= 0; i--) 
	        { 
			 double a = (list.get(i).getPerimeter()/exp)%10;
	          int j = (int) Math.round(a);
	           int index = count[j]-1; 
	          tempResult1[index] = list.get(i);  
	            count[ j ]--; 
	        }
	            list.clear();
	            list.addAll(Arrays.asList(tempResult1));
	}
	/**
	 * performs the radix sort based on Perimeter
	 * @param list
	 * @return sorted list;
	 */
	public static List<Shape> radixsortPerimeter(List<Shape> list) 
    { 
        double max = getMax(list); 
        for (int exp = 1; max/exp >  0; exp *= 10) {
            countSortPerimeter(list, exp); 
        }
        return list;
    } 
	
	/*
	 * count sort algorithm 
	 * getting a kind of hash with the help of count array 
	 * then sorting according to a radix
	 */
	private static void countSortDistance(List<Shape> list,int exp){
		Shape[] tempResult1 = new Shape[list.size()];
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (int i = 0; i < list.size(); i++) {
	          double a = (list.get(i).getDistance()/exp)%10;
	          int j = (int) Math.round(a);
			 count[ j ]++; 
		 }
		 for (int i = 1; i < 10; i++){
	            count[i] += count[i - 1]; 
		 }
		 for (int i = list.size()-1; i >= 0; i--) 
	        { 
			 double a = (list.get(i).getDistance()/exp)%10;
	          int j = (int) Math.round(a);
	           int index = count[j]-1; 
	          tempResult1[index] = list.get(i);  
	            count[ j ]--; 
	        }
	            list.clear();
	            list.addAll(Arrays.asList(tempResult1));
	}
	/**
	 * performs the radix sort based on Perimeter
	 * @param list
	 * @return sorted list;
	 */
	public static List<Shape> radixsortDistance(List<Shape> list) 
    { 
        double max = getMax(list); 
        for (int exp = 1; max/exp >  0; exp *= 10) {
            countSortDistance(list, exp); 
        }
        return list;
    } 
	/*
	*overriding comparator method to sort according to date
	*/
	private static Comparator<Shape> shapeSortTimeStamp = new Comparator<Shape>() {
		public int compare(Shape s1, Shape s2)
		{

			Date date1 = s1.getTimeStamp();
			Date date2 = s2.getTimeStamp();
			
			if(date1.after(date2))
				return -1;
			else if(date2.after(date1))
				return 1;
			return 0;
		}
	};
	/**
	 * performs the sort based on Date time stamp
	 * @param list
	 * @return sorted list;
	 */
	public static List<Shape> sortDate(List<Shape> list){
		Collections.sort(list,shapeSortTimeStamp);
		return list;
	}
	
	
}