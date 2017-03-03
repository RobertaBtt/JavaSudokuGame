package com.npaw.sudoku;

import java.util.List;
import java.util.Map;

public class ResolveByColumnsThread extends ResolverThread {

	private Sudoku sudoku;

	ResolveByColumnsThread(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public void run() {
		{
			Map<Integer, List<GameCell>> columns = sudoku.getColumns();
			computeElements(sudoku, columns);
		}
	}

}
