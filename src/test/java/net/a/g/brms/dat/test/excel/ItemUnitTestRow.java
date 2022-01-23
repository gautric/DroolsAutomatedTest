package net.a.g.brms.dat.test.excel;

import com.creditdatamw.zerocell.annotation.Column;
import com.creditdatamw.zerocell.annotation.RowNumber;
import com.creditdatamw.zerocell.annotation.ZerocellReaderBuilder;

import net.a.g.brms.dat.enumeration.Gender;
import net.a.g.brms.dat.enumeration.Species;
import net.a.g.brms.dat.test.converter.AdultConverter;
import net.a.g.brms.dat.test.converter.GenderConverter;
import net.a.g.brms.dat.test.converter.ResultConverter;
import net.a.g.brms.dat.test.converter.SpeciesConverter;

@ZerocellReaderBuilder
public class ItemUnitTestRow {
	@RowNumber
	private int rowNumber;

	@Column(index = 0, name = "Test name")
	private String testName;

	@Column(index = 1, name = "name")
	private String name;

	@Column(index = 2, name = "species", converterClass = SpeciesConverter.class)
	private Species species;

	@Column(index = 3, name = "age")
	private int age;

	@Column(index = 4, name = "gender", converterClass = GenderConverter.class)
	private Gender gender;

	@Column(index = 5, name = "result", converterClass = ResultConverter.class)
	private boolean result;

	@Column(index = 6, name = "adult", converterClass = AdultConverter.class)
	private boolean adult;

	@Column(index = 7, name = "message")
	private String message;
	
	@Column(index = 8, name = "fired")
	private int fired;


	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public Species getSpecies() {
		return species;
	}

	public String getTestName() {
		return testName;
	}

	public boolean isAdult() {
		return adult;
	}

	public boolean isResult() {
		return result;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getFired() {
		return fired;
	}

	public void setFired(int fired) {
		this.fired = fired;
	}

	@Override
	public String toString() {
		return "ItemUnitTestRow [rowNumber=" + rowNumber + ", testName=" + testName + ", name=" + name + ", species="
				+ species + ", age=" + age + ", gender=" + gender + ", result=" + result + ", adult=" + adult
				+ ", message=" + message + ", fired=" + fired + "]";
	}

	

}