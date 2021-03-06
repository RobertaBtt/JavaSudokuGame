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

	public abstract boolean isResolved();
	public abstract void addElement(Integer element);
	public abstract Integer getFirstElement();	
	public abstract Integer getElement();	
	public abstract void setElements(List<Integer> elements);
	public abstract int getRow();
	public abstract int getColumn();
	public abstract int getMatrix();	
	
	

}
