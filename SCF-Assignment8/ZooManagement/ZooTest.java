package com.metacube.zoo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ZooTest {
	
	@Test
	public void zoneCreationTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(4, true, false, "Mammal");
		int expected =1;
		assertEquals(expected,zoo1.getListOfZone().size());
	}
	@Test
	public void addNewAnimalTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(4, true, false, "Mammal");
		boolean expected =true;
		Animal lionObj=new Lion("Simba",4,100f);
		assertEquals(expected,zoo1.addAnimalToZoo(lionObj));
	}
	// adding two lions to a single cage
	@Test
	public void addNewAnimalToExistingCageTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(4, true, false, "Mammal");
		boolean expected =true;
		Animal lionObj=new Lion("Simba",4,100f);
		zoo1.addAnimalToZoo(lionObj);
		Animal lionObj1=new Lion("Simba2",4,100f);
		assertEquals(expected,zoo1.addAnimalToZoo(lionObj1));
	}
	// adding 5 lions to the zoo
	@Test
	public void addNewAnimalsToExistingCageTest() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(3, true, false, "Mammal");
		boolean expected =true;
		Animal lionObj=new Lion("Simba",4,100f);
		Animal lionObj2=new Lion("Simba2",4,100f);
		Animal lionObj3=new Lion("Simba3",4,100f);
		Animal lionObj4=new Lion("Simba4",4,100f);
		Animal lionObj5=new Lion("Simba5",4,100f);
		System.out.println("1");
		zoo1.addAnimalToZoo(lionObj);
		System.out.println("2");
		zoo1.addAnimalToZoo(lionObj2);
		System.out.println("3");
		zoo1.addAnimalToZoo(lionObj3);
		System.out.println("4");
		zoo1.addAnimalToZoo(lionObj4);
		
		assertEquals(expected,zoo1.addAnimalToZoo(lionObj5));
	}
	// creating a new Zone for bird then adding Pigeon into it
	@Test
	public void addBird() {
		Zoo zoo1 = new Zoo();
		zoo1.addZone(1, false, true, "Bird");
		zoo1.addZone(3, false, true, "Mammal");
		List<Animal> lionList = new ArrayList<Animal>();
		StringBuilder nameLion =new StringBuilder("Simba");
		StringBuilder namePigeons =new StringBuilder("Kabootar");
		List<Animal> birdList = new ArrayList<Animal>();
		for(int i=0;i<5;i++) {
			
			lionList.add(new Lion(nameLion.append(i).toString(),i,i+10f));
			birdList.add(new Pigeon(namePigeons.append(i).toString(),i,.25f));
			zoo1.addAnimalToZoo(lionList.get(i));
			zoo1.addAnimalToZoo(birdList.get(i));
		
		}
	}
	
	//there is no zone for lion and trying to add lion to zoo
	@Test(expected=AssertionError.class)
	public void addAnimalW_OZone(){
		Zoo zoo1 = new Zoo();
		int limitOfCage = 2;
		zoo1.addZone(limitOfCage, false, true, "Bird");
		Animal lionObj = new Lion("Peter",2,100f);
		zoo1.addAnimalToZoo(lionObj);
	}
	//cage limit reached
	@Test(expected=AssertionError.class)
	public void addMoreAnimals() {
		Zoo zoo1 = new Zoo();
		int limitOfCage = 3;
		zoo1.addZone(limitOfCage, true, true, "Mammal");
		List<Animal> lionList = new ArrayList<Animal>();
		for(int i=0;i<7;i++) {
			lionList.add(new Lion("Simba",i,i+10f));
			zoo1.addAnimalToZoo(lionList.get(i));
		}
		
	}
	//trying to animal with same name.
	@Test(expected=AssertionError.class)
	public void addSameName() {
		Zoo zoo1 = new Zoo();
		int limitOfCage = 3;
		zoo1.addZone(limitOfCage, true, true, "Mammal");
		List<Animal> lionList = new ArrayList<Animal>();
		for(int i=0;i<2;i++) {
			lionList.add(new Lion("Simba",i,i+10f));
			zoo1.addAnimalToZoo(lionList.get(i));
		}
	}
	
	@Test
	public void killAnimal() {
		Zoo z1 = new Zoo();
		z1.addZone(3,true,true,"Reptile");
		Animal snakeObj=new Snake("Kaa",12,20f);
		z1.addAnimalToZoo(snakeObj);
		assertEquals(true,z1.mustDie("Kaa"));
	}
	
	//adding kaa again after killing
	@Test
	public void addAgain() {
		Zoo z1 = new Zoo();
		z1.addZone(1,true,true,"Reptile");
		Animal snakeObj=new Snake("Kaa",12,20f);
		Animal snakeObj2=new Snake("Sir Hiss",12,20f);
		Animal snakeObj3=new Snake("Nagini",12,20f);
		z1.addAnimalToZoo(snakeObj);
		z1.addAnimalToZoo(snakeObj2);
		z1.mustDie("Kaa");
		z1.addAnimalToZoo(snakeObj3);
		z1.addZone(2, false, false, "Reptile");
		z1.addAnimalToZoo(snakeObj);
	}
	
	@Test(expected=AssertionError.class)
	public void nullNameLion(){
		Animal lionObj = new Lion(null,4,4.5f);
	}
	@Test(expected=AssertionError.class)
	public void nullNamePigeon(){
		Animal pigeonsObj = new Pigeon(null,4,4.5f);
	}
	@Test(expected=AssertionError.class)
	public void nullNameSnake(){
		Animal snakeObj = new Snake(null,4,4.5f);
	}
	
	
	
}