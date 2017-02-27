package com.npaw.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuResolver implements ISudokuResolver {

	//The core of the Sudoku Application
	public Sudoku resolveSudoku(Sudoku sudoku) {

		GameCell[][] sudokuCells = sudoku.getSudokuCells();

		if (sudokuCells != null) {
			
			for (int r = 0; r < sudokuCells.length; r++) {
				for (int c = 0; c < sudokuCells.length; c++) {

					if (sudokuCells[r][c].getElement() == null) {
						
						//Se per ogni cella, elemento é null
						//vuol dire che ancora non ho risolto per 
						//quella cella
						
						//Allora richiamo un metodo che é risolvi La cella
						//che dovrebbe essere ricorsivo
						
						//vai avanti finché sudoku non é resolved.
						//potrebbe essereun evento, con i sottoscrittori dell'evento ? : (
						//non lo so...
						

						List<Integer> possibilities = getPossibilities(sudoku,
								sudokuCells[r][c], sudokuCells);
					}
				}
				System.out.println();
			}
		}

		return null;
	}
	

	public List<Integer> getSiblingsofACell(Sudoku sudoku, GameCell sudokuCell ) {

		List<Integer> rowSiblings = new ArrayList<Integer>();

	
		return rowSiblings;
	}
	
	public List<Integer> getSiblingsOfRow(Sudoku sudoku, GameCell sudokuCell, GameCell[][] sudokuCells) {

		List<Integer> rowSiblings = new ArrayList<Integer>();

		for (int c = 0; c < sudoku.getSize(); c++) {
			if (c != sudokuCell.getColumn()) {

				Integer element = sudokuCells[sudokuCell.getRow()][c]
						.getElement();
				if (element != null) {
					rowSiblings.add(element);
				}
			}
		}
		return rowSiblings;
	}

	public List<Integer> getSiblingsOfColumn(Sudoku sudoku, GameCell sudokuCell, GameCell[][] sudokuCells) {

		List<Integer> rowSiblings = new ArrayList<Integer>();

		for (int r = 0; r < sudoku.getSize(); r++) {
			if (r != sudokuCell.getRow()) {
				Integer element = sudokuCells[r][sudokuCell.getColumn()]
						.getElement();
				if (element != null) {
					rowSiblings.add(element);
				}
			}
		}
		return rowSiblings;
	}

	public List<Integer> getSiblingsOfMatrix(Sudoku sudoku, GameCell sudokuCell, GameCell[][] sudokuCells) {

		List<Integer> rowSiblings = new ArrayList<Integer>();

		for (int r = 0; r < sudoku.getSize(); r++) {
			for (int c = 0; c < sudoku.getSize(); c++) {

				if (sudokuCell.getMatrix() == sudokuCells[r][c].getMatrix()) {
					if (!(r == sudokuCell.getRow() && (c == sudokuCell.getColumn()))) {
						Integer element = sudokuCells[r][c].getElement();
						if (element != null) {
							rowSiblings.add(element);
						}
					}

				}
			}

		}
		return rowSiblings;

	}

	public Sudoku resolveSudoku() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sudoku sudoku() {
		// TODO Auto-generated method stub
		return null;
	}

	

	private List<Integer> getPossibilities(Sudoku sudoku, GameCell gameCell, GameCell[][] gameCells) {
		List<Integer> siblings = this.getSiblingsofACell(sudoku, gameCell);
		List<Integer> siblingsOfRow = this.getSiblingsOfRow(sudoku, gameCell, gameCells);
		List<Integer> siblingsOfColumn = this.getSiblingsOfColumn(sudoku, gameCell, gameCells);
		//List<Integer> siblingsOfMatrix = this.getSiblingsOfMatrix(sudoku, gameCell, gameCells);

		return null;
	}

}
