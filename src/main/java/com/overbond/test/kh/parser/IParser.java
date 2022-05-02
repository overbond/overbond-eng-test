package com.overbond.test.kh.parser;

import com.overbond.test.kh.model.IData;
import com.overbond.test.kh.model.IRow;

public interface IParser<Key, T> {
	
	public IRow<Key, ? extends IData<?>> praseData(T parsableData);
}
