package net.a.g.brms.dat.test.converter;

import com.creditdatamw.zerocell.converter.Converter;

public class AdultConverter implements Converter<Boolean> {

	private static final String TRUE = "true";

	@Override
	public Boolean convert(String value, String columnName, int row) {
		return TRUE.equals(value);
	}

}
