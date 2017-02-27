package com.npaw.sudoku;

import java.util.List;

public interface  ISudokuResolver {

	public Sudoku resolveSudoku(Sudoku sudoku);
	public List<Integer> getSiblingsOfRow(Sudoku sudoku, GameCell sudokuCell, GameCell[][] sudokuCells);
	public List<Integer> getSiblingsOfColumn(Sudoku sudoku, GameCell sudokuCell, GameCell[][] sudokuCells);
	public List<Integer> getSiblingsOfMatrix(Sudoku sudoku, GameCell sudokuCell, GameCell[][] sudokuCells);
}
