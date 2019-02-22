package net.a.g.brms.dat.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class ExcelToDrlDemo {

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {
		InputStream is = null;

		is = new FileInputStream(
				"/Users/gautric/Source/git/DroolsAutomatedTest/src/main/resources/net/a/g/brms/dat/rule/excel/character.xls");

		SpreadsheetCompiler sc = new SpreadsheetCompiler();
		String drl = sc.compile(is, InputType.XLS);
		System.out.println("Generate DRLfile is–:");
		System.out.println(drl);
	}
}