package com.npaw.sudoku;

import java.util.List;

public class SudokuCell extends GameCell{

		
	public SudokuCell(String keyString, List<Integer> cellElements){
		key = keyString;
		elements = cellElements;
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
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
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
		return Integer.valueOf(key.substring(0,1));
	}


	@Override
	public int getColumn() {		
		return Integer.valueOf(key.substring(2,3));
	} 
	
	@Override
	public int getMatrix() {		
		return Integer.valueOf(key.substring(4,5));
	} 
		
}
