package net.a.g.brms.dat.test.converter;
import com.creditdatamw.zerocell.converter.Converter;

import net.a.g.brms.dat.enumeration.Species;

public class SpeciesConverter implements Converter<Species> {

	@Override
	public Species convert(String value, String columnName, int row) {
		return Species.valueOf(value);
	}

}
