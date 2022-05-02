package com.overbond.test.kh.model.concrete;

import com.overbond.test.kh.model.IData;

public class Data<T> implements IData<T> {
	
	public T data;
	
	public Data(T data) {
		super();
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public String getDataAsString() {
		return data.toString();
	}

}
