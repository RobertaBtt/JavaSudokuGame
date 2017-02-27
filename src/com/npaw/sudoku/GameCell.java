package com.npaw.sudoku;
import java.util.List;


public abstract class GameCell {

	String key;
	List<Integer> elements;
	int row;
	int column;
	int matrix;
	
	public List<Integer> getElements() {
		return elements;
	}

	public abstract Integer getFirstElement();
	
	public abstract Integer getElement();
	
	public abstract int getRow();
	public abstract int getColumn();
	public abstract int getMatrix();	
	
	//public abstract Integer getFirstElement();
//	
//	public abstract void setElements(List<Integer> elements);
//
//	public abstract String getKey();
//	
//	public abstract void setKey(String key);
}
