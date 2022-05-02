package com.overbond.test.kh.parser;

public class IntegerParserFactory {

	public static IParser<Integer, String[]> getParser(ParserType parserType) {
		switch (parserType) {
		case CSV:
			return new CsvPraser();
		default:
			break;
		}
		return null;
	}
}
