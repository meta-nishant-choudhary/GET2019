package com.metacube.zoo;

public class Lion extends Mammal {
	public Lion(String name, int age, float weight) {
		if (name == null) {
			throw new AssertionError("name required. null not allowed");
		}
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.sound = "Roar";
		this.animalId = "Lion" + (++animalCount);
	}
}
