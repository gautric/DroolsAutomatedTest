package net.a.g.brms.dat.test.util;
import com.creditdatamw.zerocell.converter.Converter;

import net.a.g.brms.dat.model.enumeration.Species;

public class SpeciesConverter implements Converter<Species> {

	@Override
	public Species convert(String value, String columnName, int row) {
		return Species.valueOf(value);
	}

}
