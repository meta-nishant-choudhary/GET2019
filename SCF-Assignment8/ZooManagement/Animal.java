package com.metacube.zoo;

public class Animal {
	public String name;
	public Integer age;
	public float weight;
	public String animalId;
	public String sound;

	public static Integer animalCount=0;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getWeight() {
		return weight;
	}

	public String getAnimalId() {
		return animalId;
	}

	public String getSound() {
		return sound;
	}

}
