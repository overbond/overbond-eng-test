package com.overbond.test.kh.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.overbond.test.kh.model.IData;
import com.overbond.test.kh.model.IRow;
import com.overbond.test.kh.model.concrete.DataFactory;
import com.overbond.test.kh.model.concrete.Row;

public class CsvPraser implements IParser<Integer, String[]> {

	Logger logger = LoggerFactory.getLogger(CsvPraser.class);

	public IRow<Integer, ?> praseData(String[] parsableData) {
		IRow<Integer, IData<?>> row = new Row<>();
		int count = 0;
		for (String record : parsableData) {
			IData<?> data = DataFactory.createData(record);
			row.addData(count, data);
			count++;
		}
		return row;
	}
}
