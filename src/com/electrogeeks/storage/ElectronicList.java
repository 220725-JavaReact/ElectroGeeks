package com.electrogeeks.storage;

import com.electrogeeks.models.Electronic;
import com.electrogeeks.util.Logger;
import com.electrogeeks.util.Logger.LogLevel;

public class ElectronicList {
	private Electronic[] electronicList;
	private int lastIndex;
	private static Logger logger = Logger.getLogger();
	public ElectronicList() {
		this.lastIndex = 0;
		electronicList=new Electronic[5];
	}
	
	public void add(Electronic electronic) {
		if(lastIndex == electronicList.length) {
			int newSize = (int)(lastIndex * 1.5);
			Electronic[] newArray = new Electronic[newSize];
			System.arraycopy(electronic, 0, newArray, 0, electronicList.length);
			electronicList = newArray;
		}
		electronicList[lastIndex] = electronic;
		logger.log(LogLevel.info, "Add to electronicList["+lastIndex+"]: "+electronic);
		lastIndex ++;
	}
	public Electronic[] get() {
		return electronicList;
	}
	public int getLastIndex() {
		return this.lastIndex;
	}
}
