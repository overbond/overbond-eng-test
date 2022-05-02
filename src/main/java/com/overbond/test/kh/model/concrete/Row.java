package com.overbond.test.kh.model.concrete;

import java.util.HashMap;
import java.util.Map;

import com.overbond.test.kh.model.IData;
import com.overbond.test.kh.model.IRow;

public class Row<Key, Value extends IData<?>> implements IRow<Key, Value> {

	private Map<Key, Value> dataSet = new HashMap<Key, Value>();

	@Override
	public Map<Key, Value> getData() {
		return dataSet;
	}

	@Override
	public void addData(Key key, Value data) {
		this.dataSet.put(key, data);
	}

	@Override
	public Value getDataForKey(Key key) {
		return dataSet.getOrDefault(key, (Value) new NullData(null));
	}
}
