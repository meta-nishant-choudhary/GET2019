package com.metacube.zoo;

public class Pigeon extends Bird {
	public Pigeon(String name, int age, float weight) {
		if (name == null) {
			throw new AssertionError("name required. null not allowed");
		}
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.sound = "Coo";
		this.animalId = "Pigeon" + (++animalCount);
	}
}
