package com.metacube.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	public Integer limitOnCages;
	public boolean hasCanteen;
	public boolean hasPark;
	public String zoneType;
	public List<Cage> listOfCages =new ArrayList<Cage>();
	public Zone(int limit,boolean canteen,boolean park,String type){
		this.limitOnCages=limit;
		this.hasCanteen=canteen;
		this.hasPark=park;
		this.zoneType=type;
	}
	/**
	 * add a new cage to the zone. the animal type that cage can accommodate must be equal to the zone type
	 * @param addCageObj   cage that is to be added
	 * @return true if the cage is added else false
	 */
	public boolean addCage(Cage addCageObj){
		if(addCageObj.getAnimalCategory().equals(zoneType)){
			if(limitOnCages-listOfCages.size()>0){
				listOfCages.add(addCageObj);
				return true;
			}
		}
		return false;
	}
	/**
	 * create a new cage for the animal 
	 * if the limit is not reached
	 */
	private boolean createCage(Animal aniObj){
		
			if(limitOnCages-listOfCages.size()>0){
				Cage cage = new Cage(aniObj,5);
				cage.addAnimalToCage(aniObj);
				listOfCages.add(cage);
				return true;
			}
			else{
				return false;
			}
	}
	/**
	 * add a new animal to the zoo until there is space available 
	 * @param aniObj animal that is to be added
	 * @return true if animal is added else false
	 */
	public boolean addAnimalToZone(Animal aniObj){
		
		//if there is no cage present in the zone then add new cage with animal inserted.
		 
		if(this.listOfCages.isEmpty()){
			this.createCage(aniObj);
			return true;
		}
		/*
		 * find the exact cage for that animal.
		 */
		else{
			for(int i=0;i<this.listOfCages.size();i++){
				Cage cageFindObj = listOfCages.get(i);
				String animalType = aniObj.getClass().getSimpleName();
				// check the animal Type of fetched cage.
				if(cageFindObj.getAnimalType().equals(animalType) && cageFindObj.spaceAvailable()){
					cageFindObj.addAnimalToCage(aniObj);
					
					return true;
				}
			}
			
		}
		return false;		// this statement is only reached when cage can't be added.
	}
	public String getZoneType(){
		return this.zoneType;
	}
	public List<Cage> getCageList(){
		return new ArrayList<Cage>(this.listOfCages);
	}
	/**
	 * finds an animal in the zone
	 * @param name
	 * @return true if animal is found else false
	 */
	public boolean findName(String name) {
		for(int i=0;i<this.listOfCages.size();i++) {
			if(listOfCages.get(i).findNameInCage(name)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * kills an animal with the given name,
	 * finds the animal in each cage in this zone
	 * @param name
	 * @return true if animal is killed, else false
	 */
	public boolean kill(String name) {
		for(int i=0;i<this.listOfCages.size();i++) {
			if(listOfCages.get(i).kill(name)) {
				return true;
			}
		}
		return false;
	}
}