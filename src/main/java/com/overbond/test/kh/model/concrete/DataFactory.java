package com.overbond.test.kh.model.concrete;

import java.util.Objects;

import com.overbond.test.kh.model.IData;

public class DataFactory {
	
	public static IData<?> createData(String data) {
		Long numbericData = getNumeric(data);
		if (Objects.nonNull(numbericData)) {
			return new LongData(numbericData);
		} else if(Objects.nonNull(data)) {
			return new StringData(data);
		} else {
			return new NullData(data);
		}
	}

	private static Long getNumeric(String data) {
		if (data == null) {
			return null;
		}
		try {
			Long d = Long.parseLong(data);
			return d;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}
}
