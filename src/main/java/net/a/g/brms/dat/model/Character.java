package net.a.g.brms.dat.model;

import net.a.g.brms.dat.enumeration.Gender;
import net.a.g.brms.dat.enumeration.Species;

public class Character {

	private String name;
	private Species species;
	private int age;
	private Gender gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[Character : name:" + name + ",species:" + species + ",age:" + age + ",gender:" + gender + "]";
	}

}
