package com.npaw.sudoku;

import java.util.List;

public interface SudokuGroup {
	
	public List<GameCell> getCells();
	public void addCell(GameCell gameCell);

}
