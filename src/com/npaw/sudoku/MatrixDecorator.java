package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.List;

public class MatrixDecorator  {

	GameCell gameCell;

	public MatrixDecorator(GameCell sudokuCell) {
		this.gameCell = sudokuCell;
	}

	public List<Integer> getSiblings() {
		return new ArrayList<Integer>();

	}
	
	
}
