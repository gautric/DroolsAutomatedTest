package net.a.g.brms.dat.test.util;
import com.creditdatamw.zerocell.converter.Converter;

import net.a.g.brms.dat.model.enumeration.Gender;

public class GenderConverter implements Converter<Gender> {

	@Override
	public Gender convert(String value, String columnName, int row) {
		return Gender.valueOf(value);
	}

}
