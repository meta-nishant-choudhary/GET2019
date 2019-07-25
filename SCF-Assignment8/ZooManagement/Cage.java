package com.metacube.zoo;

import java.util.ArrayList;
import java.util.List;

public class Cage {
	public String animalCategory;
	public String animalType;
	public Integer limit;

	public List<Animal> listOfAnimals = new ArrayList<Animal>();

	public Cage(Animal aniObj, int limit) {
		this.animalType = aniObj.getClass().getSimpleName();
		this.limit = limit;
		this.animalCategory = aniObj.getClass().getSuperclass().getSimpleName();
	}

	/**
	 * add an animal to the cage
	 * @param aniObj animal to be added
	 * @return true
	 */
	public boolean addAnimalToCage(Animal aniObj) {
		listOfAnimals.add(aniObj);
		return true;
	}

	/**
	 * check whether there is space available in the cage or not.
	 * @return true if there is space else false.
	 */
	public boolean spaceAvailable() {
		int size = limit - listOfAnimals.size();
		if (size > 0) {
			return true;
		}
		return false;
	}

	public String getAnimalCategory() {
		return animalCategory;
	}

	public String getAnimalType() {
		return animalType;
	}

	/**
	 * looks for a name among all the animals in this cage 
	 * @param name
	 * @return true if name is found, else false
	 */
	public boolean findNameInCage(String name) {
		for (int i = 0; i < this.listOfAnimals.size(); i++) {
			if (listOfAnimals.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * find an animal and kill it by removing it from cage 
	 * @param name
	 * @return true if name is found, else false
	 */
	public boolean kill(String name) {
		for (int i = 0; i < this.listOfAnimals.size(); i++) {
			if (listOfAnimals.get(i).getName().equals(name)) {
				listOfAnimals.remove(i);
				return true;
			}
		}
		return false;
	}

}
