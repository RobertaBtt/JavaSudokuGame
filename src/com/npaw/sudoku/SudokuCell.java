package com.npaw.sudoku;

import java.util.List;

public class SudokuCell extends GameCell{

		
	//cellElements are the numbers
	public SudokuCell(int rowId, int columnId, int matrixId, List<Integer> numbers){
		this.row = rowId;
		this.column = columnId;
		this.matrix = matrixId;
		elements = numbers;
	}
	
	
	//deprecated
	public SudokuCell(String keyString, List<Integer> cellElements){
		
		key = keyString;
		elements = cellElements;
	}
	
	@Override
	public boolean isResolved(){
		if (elements.size() == 1){
			return true;
		}
		return false;
		
	}
	
	public void addElement(Integer element){
		elements.add(element);
	}
	
	public Integer getFirstElement() {
		if (elements.size()>0){
			return elements.get(0);	
		}
		else return 0;
		
	}
	
	public void setElements(List<Integer> elements) {
		this.elements = elements;
	}
	
	

	@Override
	public Integer getElement() {
		
		if (elements.size()== 1){
			return elements.get(0);	
		}
		else if (elements.size() > 1){
			return null;
		}
		else return null;
	}


	@Override
	public int getRow() {
		return this.row;
	}


	@Override
	public int getColumn() {		
		return this.column;
	} 
	
	@Override
	public int getMatrix() {		
		return this.matrix;
	} 
		
}
