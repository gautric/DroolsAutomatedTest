package net.a.g.brms.dat.test.converter;

import com.creditdatamw.zerocell.converter.Converter;

import net.a.g.brms.dat.enumeration.Gender;
import net.a.g.brms.dat.enumeration.Species;

public class GenderConverter implements Converter<Gender> {

	@Override
	public Gender convert(String value, String columnName, int row) {
		try {
			return Gender.valueOf(value);
		} catch (Exception e) {
			return null;
		}
	}

}
