package com.metacube.zoo;

public class Snake extends Reptile {
	public Snake(String name, int age, float weight) {
		if (name == null) {
			throw new AssertionError("name required. null not allowed");
		}
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.sound = "Hiss";
		this.animalId = "Snake" + (++animalCount);
	}
}