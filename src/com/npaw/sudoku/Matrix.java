package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Matrix implements SudokuGroup{

	List<GameCell> gameCells;
	
	public Matrix() {
		this.gameCells = new ArrayList<GameCell>();
	}
	
	public List<GameCell> getCells() {
		return gameCells;
	}

	public void addCell(GameCell gameCell) {
		this.gameCells.add(gameCell);
		
	}
	
}
