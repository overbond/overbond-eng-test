package com.overbond.test.kh.model;

import java.util.Map;

public interface IRow<Key, Value extends IData<?>> {
	
	public Map<Key,Value> getData();
	
	public Value getDataForKey(Key key);

	public void addData(Key key,Value value);

}
