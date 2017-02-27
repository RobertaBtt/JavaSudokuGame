package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.List;

public class ColumnDecorator  {

	GameCell gameCell;

	public ColumnDecorator(GameCell sudokuCell) {
		this.gameCell = sudokuCell;
	}

	public List<Integer> getSiblings() {
		return new ArrayList<Integer>();

	}

}
