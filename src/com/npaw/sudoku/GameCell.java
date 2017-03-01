package com.npaw.sudoku;
import java.util.List;
import java.util.Set;


public abstract class GameCell {

	String key;
	List<Integer> elements;
	int row;
	int column;
	int matrix;
	
	public List<Integer> getElements() {
		return elements;
	}

	public abstract boolean isResolved();
	public abstract void addElement(Integer element);
	public abstract Integer getFirstElement();	
	public abstract Integer getElement();	
	public abstract int getRow();
	public abstract int getColumn();
	public abstract int getMatrix();	
	
	

}
