package net.a.g.brms.dat.test.converter;
import com.creditdatamw.zerocell.converter.Converter;

public class ResultConverter implements Converter<Boolean> {

	private static final String OK = "OK";

	@Override
	public Boolean convert(String value, String columnName, int row) {
		return OK.equals(value);
	}

}
