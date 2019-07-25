package com.metacube.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	
	public List<Zone> listOfZone= new ArrayList<Zone>();
	
	public Zone addZone(int limit,boolean canteen,boolean park,String zoneType){
			Zone zone=new Zone(limit,canteen,park,zoneType);
			listOfZone.add(zone);
			return zone;
		}
	
	
	
	/**
	 * check for unique name of animal
	 * @param aniObj  animal to be added to zoo.
	 * @return true if the name is unique, else false
	 */
	private boolean checkUnique(Animal aniObj) {
		for(int i=0;i<listOfZone.size();i++) {
			if(listOfZone.get(i).findName(aniObj.name)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * remove the animal from zoo
	 * @param aniObj
	 * @return
	 */
	public boolean mustDie(String name) {
		for(int i=0;i<listOfZone.size();i++) {
			if(listOfZone.get(i).kill(name)) {
				return true;
			}
		}
		throw new AssertionError("no animal with this name");
	}
	
	/*
	 * adding the animal to the available zone.
	 */
	public boolean addAnimalToZoo(Animal aniObj){
		if(listOfZone.isEmpty()){
			throw new AssertionError("no zone in the zoo."); 
		}
		else{
			if(checkUnique(aniObj)) {
				
				/*
				 * iterate through the zones and find the zone matching the animal category
				 */
				for(int i=0;i<listOfZone.size();i++){
					Zone zoneObj = listOfZone.get(i);
					String animalCategoryInList = zoneObj.getZoneType();							 //category of zone
					String animalCategoryInput = aniObj.getClass().getSuperclass().getSimpleName();
					if(animalCategoryInList.equals(animalCategoryInput)){
						if(zoneObj.addAnimalToZone(aniObj)) {		//when the zone if found try to add animal in it.
							return true;
						}
					}
				}
			}
			else {
				 
				throw new AssertionError("Name must be unique");
			}
		}
		throw new AssertionError("No Zone for this animal or Cage limit is reached, add new zone.");
		
	}
	public List getListOfZone() {
		return new ArrayList<Zone>(this.listOfZone);
	}
	
}