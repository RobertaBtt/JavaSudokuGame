package com.npaw.sudoku;


import java.util.List;
import java.util.Map;

public class ResolveByRowsThread extends ResolverThread {

	private Sudoku sudoku;

	ResolveByRowsThread(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public void run() {

		int sudokuSize = sudoku.getSize();
		int expectedResolvedCell = sudokuSize * sudokuSize;
		Map<Integer, List<GameCell>> rows = sudoku.getRows();

		while (sudoku.getResolvedNumberCell() < expectedResolvedCell) {
			computeElements(sudoku, rows);
		}

	}


}
