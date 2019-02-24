package com.npaw.sudoku;

import java.util.List;
import java.util.Map;

public class ResolveByMatrixThread extends ResolverThread {

	private Sudoku sudoku;

	ResolveByMatrixThread(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public void run() {
		{
			Map<Integer, List<GameCell>> matrix = sudoku.getMatrix();
			computeElements(sudoku, matrix);
		}
	}

}
